package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Models.Ticket;
import Models.User;
import Services.BookingService;
import config.DatabaseUtil;
import dao.TicketDAO;

/**
 * Servlet implementation class TicketController
 */
@WebServlet("/tickets")
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Récupérer la liste des tickets réservés depuis le service
//     // Obtenir une connexion à la base de données
//        Connection connection = DatabaseUtil.getConnection(); // Assurez-vous que DatabaseUtil contient une méthode getConnection() qui renvoie une connexion valide
//
//        // Créer un objet TicketDAO avec la connexion à la base de données
//        TicketDAO ticketDAO = new TicketDAO(connection);
//
//        // Créer une instance de BookingService avec le TicketDAO
//        BookingService bookingService = new BookingService(ticketDAO);
//        List<Ticket> bookedTickets = bookingService.getAllTickets();
//
//        // Ajouter les tickets réservés comme attribut à la requête
//        request.setAttribute("tickets", bookedTickets);
//
//        // Transférer la requête à votre fichier JSP
//        request.getRequestDispatcher("/WEB-INF/views/MyTickets.jsp").forward(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenir l'utilisateur connecté à partir de la session
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            // Obtenir une connexion à la base de données
            Connection connection = DatabaseUtil.getConnection();

            // Créer un objet TicketDAO avec la connexion à la base de données
            TicketDAO ticketDAO = new TicketDAO(connection);
            BookingService bookingService = new BookingService(ticketDAO);

            // Récupérer tous les tickets de l'utilisateur connecté
            List<Ticket> userTickets = bookingService.getAllTicketsByUser(user.getId());

            // Ajouter les tickets de l'utilisateur comme attribut à la requête
            request.setAttribute("tickets", userTickets);

            // Transférer la requête à votre fichier JSP pour l'affichage
            request.getRequestDispatcher("/WEB-INF/views/MyTickets.jsp").forward(request, response);
        } else {
            // Rediriger vers la page de connexion si aucun utilisateur n'est connecté
            response.sendRedirect("/DecoratorProject/LoginServlet");
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
