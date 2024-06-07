package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Models.Event;
import Services.EventService;
import Services.UserService;
import config.DatabaseUtil;
import dao.EventDAO;
import dao.UserDAO;

@WebServlet("/events")
public class EventController extends HttpServlet {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventService eventService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 Connection conn = DatabaseUtil.getConnection();
 	    
 	    if(conn != null) {
 	    	EventDAO eventDAO = new EventDAO(conn);
 	        EventService eventService = new EventService(eventDAO);
 	          
 	       List<Event> events = eventService.getAllEvents();

 	        if (events.size() > 0) {
 	        	request.setAttribute("events", events);
 	           request.getRequestDispatcher("/WEB-INF/views/eventList.jsp").forward(request, response);
 	        } else {
 	            // If registration fails, set an error message and forward back to the registration page
 	            String errorMessage = "Registration failed. Please try again.";
 	            request.setAttribute("errorMessage", errorMessage);
 	            // Assuming "register.jsp" is the path to your registration form
 	            request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
 	        }
 	    } 
        
        
    }
    //ici pour l ajout d 'event
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("eventName");
        Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("eventDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        String location = request.getParameter("eventLocation");
        float basePrice = Float.parseFloat(request.getParameter("basePrice"));

        // Créer un nouvel objet Event avec les données du formulaire
        Event event = new Event(name,location,date,basePrice);
        Connection conn = DatabaseUtil.getConnection();
 	    
 	    if(conn != null) {
 	    	EventDAO eventDAO = new EventDAO(conn);
 	        EventService eventService = new EventService(eventDAO);
 	       
 	        eventService.addEvent(event);
	       request.getRequestDispatcher("/WEB-INF/views/addEvent.jsp").forward(request, response);
 	    }

        /* Ajouter l'événement à la base de données
        if (eventService.addEvent(event)) {
            // Rediriger vers une page de confirmation ou à la liste des événements
            response.sendRedirect("events");
        } else {
            // Gérer l'échec de l'ajout
            String errorMessage = "L'ajout d'événement a échoué. Veuillez réessayer.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }*/
    }

    // Additional methods (doPost, doPut, doDelete) to handle other request types like creating, updating, or deleting events.
}
