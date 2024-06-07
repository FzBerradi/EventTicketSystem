package Services;


import java.util.List;

import Models.Event;
import dao.EventDAO;
import dao.UserDAO;
import observer.EmailNotification;
import observer.EventNotifier;


public class EventService {

  
   private EventDAO eventDAO;
   
   public EventService(EventDAO eventDAO) {
       this.eventDAO = eventDAO;
   }

   public List<Event> getAllEvents(){
	   return eventDAO.findAll();
   }
   
   public Event getEventById(Long Id) {
	   return eventDAO.findEventById(Id);
   }
   
   public Event addEvent(Event event) {
	   Event createdEvent = eventDAO.addEvent(event);
	   EventNotifier eventNotifier = new EventNotifier();
	   EmailNotification emailNotification = new EmailNotification();
	   eventNotifier.registerObserver(emailNotification);
	   eventNotifier.notifyObservers(createdEvent);
	   return createdEvent;
   }

   
}
