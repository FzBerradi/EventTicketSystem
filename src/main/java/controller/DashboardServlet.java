package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Services.DashboardService;
import config.DatabaseUtil;
import dao.EventDAO;
import dao.TicketDAO;
import dao.UserDAO;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/dashboard")
@SuppressWarnings("serial")

public class DashboardServlet extends HttpServlet {
    /**
	 * 
	 */
	private DashboardService dashboardService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialise les DAO nécessaires pour le service de tableau de bord
        Connection connection = DatabaseUtil.getConnection();
        EventDAO eventDAO = new EventDAO(connection);
        TicketDAO ticketDAO = new TicketDAO(connection);
        UserDAO userDAO = new UserDAO(connection);

        // Initialise le service de tableau de bord avec les DAO
        dashboardService = new DashboardService(eventDAO, ticketDAO,userDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appel des méthodes du service de tableau de bord pour récupérer les données nécessaires
        int numberOfEvents = dashboardService.getNumberOfEvents();
        int numberOfPendingTickets = dashboardService.getNumberOfPendingTickets();
        int numberOfBookedTickets = dashboardService.getNumberOfBookedTickets();
        int numberOfUsers = dashboardService.getNumberOfUsers();

        request.setAttribute("numberOfEvents", numberOfEvents);
        request.setAttribute("numberOfPendingTickets", numberOfPendingTickets);
        request.setAttribute("numberOfBookedTickets", numberOfBookedTickets);
        request.setAttribute("numberOfUsers", numberOfUsers);

        // Redirige vers la vue de tableau de bord
        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);

    }
}
