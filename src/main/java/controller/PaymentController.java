package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import strategy.BankTransferStrategy;
import strategy.CardPaymentStrategy;
import strategy.PayPalPaymentStrategy;
import strategy.PaymentStrategy;

import java.io.IOException;
import java.sql.Connection;

import Services.BookingService;
import Services.UserService;
import config.DatabaseUtil;
import dao.TicketDAO;
import dao.UserDAO;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/pay")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String paymentType = request.getParameter("paymentType");
	     String amount = request.getParameter("amount");
	     String ticketId = request.getParameter("ticketId");
	     //System.out.println()
	     
	     // Determine which payment strategy to use based on the payment type
        PaymentStrategy strategy;
        switch (paymentType) {
            case "card":
                String cardNumber = request.getParameter("cardNumber");
                String cvv = request.getParameter("cvv");
                String expiryDate = request.getParameter("expiryDate");
                strategy = new CardPaymentStrategy(cardNumber, cvv, expiryDate);
                break;
            case "bankTransfer":
                String accountNumber = request.getParameter("accountNumber");
                String routingNumber = request.getParameter("routingNumber");
                strategy = new BankTransferStrategy(accountNumber, routingNumber);
                break;
            case "paypal":
                String paypalEmail = request.getParameter("paypalEmail");
                strategy = new PayPalPaymentStrategy(paypalEmail);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid payment type");
                return;
        }
        
     // Process the payment using the selected strategy
        boolean paymentResult = strategy.pay(Double.parseDouble(amount));

        // Based on the payment result, redirect to the success or error page
        if (paymentResult) {
        	Connection conn = DatabaseUtil.getConnection();
     	    
     	    if(conn != null) {
     	        TicketDAO ticketDAO = new TicketDAO(conn);
     	        BookingService bookingService = new BookingService(ticketDAO);
     	          
     	        boolean result = bookingService.payTicket(Long.parseLong(ticketId), "booked");

     	        if (result) {
     	            request.getRequestDispatcher("/WEB-INF/views/SuccessPayment.jsp").forward(request, response);
     	        } else {
     	            // If registration fails, set an error message and forward back to the registration page
     	            String errorMessage = "Payment failed. Please try again.";
     	            request.setAttribute("errorMessage", errorMessage);
     	            // Assuming "register.jsp" is the path to your registration form
     	            request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(request, response);
     	        }
     	    } else {
     	        // Handle database connection failure
     	        String errorMessage = "Database connection failure. Please try again later.";
     	        request.setAttribute("errorMessage", errorMessage);
     	        // Assuming "register.jsp" is the path to your registration form
     	        request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(request, response);
     	    }
            // Redirect to a success page, including ticketId as a parameter
            response.sendRedirect("SuccessPayment.jsp?ticketId=" + ticketId);
            
        } else {
            // Redirect to a failure page, including ticketId as a parameter
            response.sendRedirect("errorPage.jsp?ticketId=" + ticketId);
        }
	}

}
