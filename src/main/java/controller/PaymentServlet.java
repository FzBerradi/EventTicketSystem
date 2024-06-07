package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read ticket ID and price from the form submission
        String ticketId = request.getParameter("ticketId");
        String amount = request.getParameter("amount");

        // Input validation can be added here as necessary

        // Set the ticket ID and price as request attributes
        request.setAttribute("ticketId", ticketId);
        request.setAttribute("amount", amount);

        // Forward the request to the JSP page for payment method selection
        request.getRequestDispatcher("/WEB-INF/views/PaymentMethods.jsp").forward(request, response);
    }
}
