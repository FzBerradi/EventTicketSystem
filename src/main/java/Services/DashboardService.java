package Services;


import dao.EventDAO;
import dao.TicketDAO;
import dao.UserDAO;

public class DashboardService {
    private EventDAO eventDAO;
    private TicketDAO ticketDAO;
    private UserDAO userDAO;

    public DashboardService(EventDAO eventDAO, TicketDAO ticketDAO,UserDAO userDAO) {
        this.eventDAO = eventDAO;
        this.ticketDAO = ticketDAO;
        this.userDAO=userDAO;
    }

    public int getNumberOfEvents() {
        return eventDAO.countAllEvents();
    }

    public int getNumberOfPendingTickets() {
        return ticketDAO.countPendingTickets();
    }

    public int getNumberOfBookedTickets() {
        return ticketDAO.countBookedTickets();
    }
    public int getNumberOfUsers() {
        return userDAO.countAllUsers();
    }
}
