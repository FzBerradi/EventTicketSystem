package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Models.Event;

public class EventDAO {

	 private Connection connection;
	 public EventDAO(Connection connection) {
        this.connection = connection;
	 }
	 
	 
	 public Event addEvent(Event event) {
	        String query = "INSERT INTO events (name, date, location, basePrice) VALUES (?, ?, ?, ?)";
	        Event createdEvent = null;

	        try (PreparedStatement pstmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
	            pstmt.setString(1, event.getName());
	            pstmt.setDate(2, new java.sql.Date(event.getDate().getTime())); // Assuming getDate returns a java.util.Date
	            pstmt.setString(3, event.getLocation());
	            pstmt.setFloat(4, (float) event.getBasePrice());

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 1) {
	                // Retrieve the auto-generated ID of the newly inserted event
	                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        int eventId = generatedKeys.getInt(1);
	                        // Create the Event object with the generated ID
	                        createdEvent = new Event((long) eventId, event.getName(),event.getLocation(),event.getDate(), event.getBasePrice());
	                    } else {
	                        throw new SQLException("Creating event failed, no ID obtained.");
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return createdEvent;
	 }

	 
	public boolean updateEvent(Event event) {
		    String query = "UPDATE events SET name = ?, date = ?, location = ?, basePrice = ? WHERE id = ?";
		    
		    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
		        pstmt.setString(1, event.getName());
		        pstmt.setDate(2, new java.sql.Date(event.getDate().getTime())); // Assuming getDate returns a java.util.Date
		        pstmt.setString(3, event.getLocation());
		        pstmt.setFloat(4, (float) event.getBasePrice());
		        pstmt.setLong(5, event.getId());
		        
		        int affectedRows = pstmt.executeUpdate();
		        return affectedRows == 1;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}


    public List<Event> findAll() {
    	List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Event event = new Event();
                event.setName(rs.getString("name"));
                event.setDate(rs.getDate("date"));
                event.setLocation(rs.getString("location"));
                event.setBasePrice(rs.getFloat("basePrice"));
                event.setId(rs.getLong("id"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return events;
    }
    
    public Event findEventById(long id) {
        String query = "SELECT * FROM events WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Event event = new Event();
                event.setId(rs.getLong("id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getDate("date"));
                event.setLocation(rs.getString("location"));
                event.setBasePrice(rs.getFloat("basePrice"));
                return event;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean deleteEvent(long id) {
        String query = "DELETE FROM events WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
   }

    public int countAllEvents() {
        String query = "SELECT COUNT(*) FROM events";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

   
}