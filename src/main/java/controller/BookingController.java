package controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import Models.Event;
import Models.Ticket;
import Models.User;
import Services.BookingService;
import Services.EventService;
import Services.UserService;
import config.DatabaseUtil;
import dao.EventDAO;
import dao.TicketDAO;
import dao.UserDAO;
import factory.TicketFactory;

@WebServlet("/booking")
public class BookingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookingService bookingService;
    private EventService eventService;
   

    public void init() {
        Connection conn = DatabaseUtil.getConnection();
        if (conn != null) {
            this.bookingService = new BookingService(new TicketDAO(conn), new EventDAO(conn));
            this.eventService = new EventService(new EventDAO(conn));
            System.out.println("Services initialized");// Message de confirmation de l'initialisation
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ticketType = request.getParameter("ticketType");// Récupération du type de billet
            Long eventId = Long.parseLong(request.getParameter("eventId"));
            HttpSession session = request.getSession(false); // Use false to not create a new session
            User user = (session != null) ? (User) session.getAttribute("user") : null;// Récupération de l'utilisateur à partir de la sessio

            Event event = eventService.getEventById(eventId);
            // Si l'événement ou l'utilisateur n'est pas trouvé, redirection vers une page d'erreur
            if (event == null || user == null) {
                // Log error and redirect or forward to an error page
                System.out.println("Event or user not found.");
                response.sendRedirect("errorPage.jsp"); // Consider creating an error page to show a user-friendly message
                return;
            }
            // Création du ticket et réservation du ticket avec le service de réservation
            Ticket ticket = TicketFactory.createTicket(ticketType, event, user);
            ticket = bookingService.bookTicket(ticket);

            // After booking, redirect to the confirmation page with ticket details
         // After booking the ticket
            request.setAttribute("ticket", ticket); // Store the whole ticket object
            request.getRequestDispatcher("/WEB-INF/views/booking-confirmation.jsp").forward(request, response); // Update with the correct path if needed
        } catch (NumberFormatException e) {
            System.out.println("Invalid event ID: " + e.getMessage());
            response.sendRedirect("/WEB-INF/views/errorPage.jsp"); // Consider creating an error page
        } catch (Exception e) {
            System.out.println("An error occurred during booking: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred during booking");
        }
    }
    

    // Additional methods to handle other actions like viewing bookings, canceling, etc.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve eventId from the request parameter
        String eventId = request.getParameter("eventId");

        // Optional: Validate eventId or perform other actions as needed
        // Définition de l'ID de l'événement comme attribut de requête pour qu'il soit accessible dans booking.jsp
        // Set eventId as a request attribute to be accessible in booking.jsp
        request.setAttribute("eventId", eventId);

        request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
    }
}
