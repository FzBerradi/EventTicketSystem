package Services;


import java.util.List;

import Models.Ticket;
import dao.EventDAO;
import dao.TicketDAO;


public class BookingService {

   
    private TicketDAO ticketDAO;
    private EventDAO eventDAO;

    public BookingService(TicketDAO ticketDAO, EventDAO eventDAO) {
        this.ticketDAO = ticketDAO;
        this.setEventDAO(eventDAO);
    }
    
    public BookingService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Ticket bookTicket(Ticket ticket) {
    	System.out.println("tciket service toString  "+ticket.toString());
        return ticketDAO.save(ticket);
    }
    
    public boolean payTicket(Long ticketId , String status) {
    	return ticketDAO.updateStatus(ticketId, status);
    }

   

    public Ticket getTicketById(Long id) {
        return ticketDAO.findById(id);
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.findAll();
    }

	public EventDAO getEventDAO() {
		return eventDAO;
	}
	 public List<Ticket> getAllTicketsByUser(long userId) {
	        return ticketDAO.findAllByUser(userId);
	    }
	 
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

   
}