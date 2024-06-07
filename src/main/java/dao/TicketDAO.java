////package dao;
////
////import Models.Ticket;
////import jakarta.persistence.EntityManager;
////import jakarta.persistence.PersistenceContext;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.sql.Statement;
////import java.util.ArrayList;
////import java.util.List;
////
////public class TicketDAO {
////
////	private Connection connection;
////	public TicketDAO(Connection connection) {
////       this.connection = connection;
////	}
////
////
////	public Ticket save(Ticket ticket) {
////	    String query = "INSERT INTO tickets (event_id, user_id, price, status) VALUES (?, ?, ?, ?)";
////
////	    // Use the overloaded version of prepareStatement to specify that you want the generated keys to be returned
////	    try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
////	        pstmt.setLong(1, ticket.getEvent().getId());
////	        pstmt.setLong(2, ticket.getUser().getId());
////	        pstmt.setDouble(3, ticket.getPrice());
////	        pstmt.setString(4, ticket.getStatus().toString());
////
////	        int affectedRows = pstmt.executeUpdate();
////
////	        if (affectedRows > 0) {
////	            // Retrieve the generated ID
////	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
////	                if (generatedKeys.next()) {
////	                    // Set the retrieved ID to the ticket object
////	                    ticket.setId(generatedKeys.getLong(1)); // Assuming the ID column is of type BIGINT
////	                } else {
////	                    throw new SQLException("Creating ticket failed, no ID obtained.");
////	                }
////	            }
////	            System.out.println("Ticket saved with ID: " + ticket.getId());
////	            return ticket;
////	        } else {
////	            return null;
////	        }
////	    } catch (SQLException e) {
////	        e.printStackTrace();
////	        System.out.println("Exception: " + e.getMessage());
////	        return null;
////	    }
////	}
////	
////	 public boolean updateStatus(Long ticketId, String status) {
////	        String query = "UPDATE tickets SET status = ? WHERE id = ?";
////
////	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
////	            pstmt.setString(1, status);
////	            pstmt.setLong(2, ticketId);
////
////	            int affectedRows = pstmt.executeUpdate();
////	            if (affectedRows > 0) {
////	                System.out.println("Ticket status updated for ID: " + ticketId);
////	                return true;
////	            } else {
////	                System.out.println("No ticket was updated. Check if the ID is correct.");
////	                return false;
////	            }
////	        } catch (SQLException e) {
////	            e.printStackTrace();
////	            System.out.println("SQL Exception: " + e.getMessage());
////	            return false;
////	        }
////	    }
////
////
////    public Ticket findById(Long id) {
////        return null;
////    }
////
//////    public List<Ticket> findAll() {
//////        return null;
//////    }
////    public List<Ticket> findTicketsByUserId(Long userId) {
////        List<Ticket> tickets = new ArrayList<>();
////        String query = "SELECT id, price, description, status  FROM tickets user_id = ?";
////        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
////            pstmt.setLong(1, userId);
////            ResultSet rs = pstmt.executeQuery();
////            while (rs.next()) {
////                Ticket ticket = new Ticket();
////                ticket.setId(rs.getLong("id"));
////                ticket.setPrice(rs.getDouble("price"));
////                ticket.setDescription(rs.getString("description"));
////                ticket.setStatus(rs.getString("status"));
////
////              
////
////                tickets.add(ticket);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return tickets;
////    }
////
////    public List<Ticket> findAll() {
////        List<Ticket> tickets = new ArrayList<>();
////        String query = "SELECT * FROM tickets";
////        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
////            ResultSet rs = pstmt.executeQuery();
////            while (rs.next()) {
////                Ticket ticket = new Ticket();
////                ticket.setId(rs.getLong("id"));
////                // Set other properties accordingly
////                tickets.add(ticket);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return tickets;
////    }
////    public int countPendingTickets() {
////        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'pending'";
////        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
////            ResultSet rs = pstmt.executeQuery();
////            if (rs.next()) {
////                return rs.getInt(1);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return 0;
////    }
////
////    public int countBookedTickets() {
////        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'booked'";
////        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
////            ResultSet rs = pstmt.executeQuery();
////            if (rs.next()) {
////                return rs.getInt(1);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return 0;
////    }
////
////}
//package dao;
//
//import Models.Event;
//import Models.Ticket;
//import Models.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TicketDAO {
//
//	private Connection connection;
//	public TicketDAO(Connection connection) {
//       this.connection = connection;
//	}
//
//
//	public Ticket save(Ticket ticket) {
//	    String query = "INSERT INTO tickets (event_id, user_id, price, status) VALUES (?, ?, ?, ?)";
//
//	    // Use the overloaded version of prepareStatement to specify that you want the generated keys to be returned
//	    try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//	        pstmt.setLong(1, ticket.getEvent().getId());
//	        pstmt.setLong(2, ticket.getUser().getId());
//	        pstmt.setDouble(3, ticket.getPrice());
//	        pstmt.setString(4, ticket.getStatus().toString());
//
//	        int affectedRows = pstmt.executeUpdate();
//
//	        if (affectedRows > 0) {
//	            // Retrieve the generated ID
//	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
//	                if (generatedKeys.next()) {
//	                    // Set the retrieved ID to the ticket object
//	                    ticket.setId(generatedKeys.getLong(1)); // Assuming the ID column is of type BIGINT
//	                } else {
//	                    throw new SQLException("Creating ticket failed, no ID obtained.");
//	                }
//	            }
//	            System.out.println("Ticket saved with ID: " + ticket.getId());
//	            return ticket;
//	        } else {
//	            return null;
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        System.out.println("Exception: " + e.getMessage());
//	        return null;
//	    }
//	}
//	
//	 public boolean updateStatus(Long ticketId, String status) {
//	        String query = "UPDATE tickets SET status = ? WHERE id = ?";
//
//	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//	            pstmt.setString(1, status);
//	            pstmt.setLong(2, ticketId);
//
//	            int affectedRows = pstmt.executeUpdate();
//	            if (affectedRows > 0) {
//	                System.out.println("Ticket status updated for ID: " + ticketId);
//	                return true;
//	            } else {
//	                System.out.println("No ticket was updated. Check if the ID is correct.");
//	                return false;
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            System.out.println("SQL Exception: " + e.getMessage());
//	            return false;
//	        }
//	    }
//	 public List<Ticket> findTicketsByUserId(Long userId) {
//		    List<Ticket> tickets = new ArrayList<>();
//		    String query = "SELECT id, price, description, status FROM tickets WHERE user_id = ?";
//		    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//		        pstmt.setLong(1, userId);
//		        ResultSet rs = pstmt.executeQuery();
//		        while (rs.next()) {
//		            Ticket ticket = new Ticket();
//		            ticket.setId(rs.getLong("id"));
//		            ticket.setPrice(rs.getDouble("price"));
//		            ticket.setDescription(rs.getString("description"));
//		            ticket.setStatus(rs.getString("status"));
//		            
//		            // Ajoutez ici la logique pour récupérer l'événement associé au ticket si nécessaire
//		            
//		            tickets.add(ticket);
//		        }
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//		    return tickets;
//		}
//
//	 // Méthode pour rechercher un ticket par son ID
//		 public Ticket findById(Long id) {
//		     String query = "SELECT * FROM tickets WHERE id = ?";
//		     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//		         pstmt.setLong(1, id);
//		         ResultSet rs = pstmt.executeQuery();
//		         if (rs.next()) {
//		             Long eventId = rs.getLong("event_id");
//		             Long userId = rs.getLong("user_id");
//		             double price = rs.getDouble("price");
//		             String status = rs.getString("status");
//		             // Créer une instance d'EventDAO en passant la connexion
//		             EventDAO eventDAO = new EventDAO(connection);
//		             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
//		             Event event = eventDAO.findEventById(eventId);
//		             // Créer une instance de UserDAO en passant la connexion
//		             UserDAO userDAO = new UserDAO(connection);
//		             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
//		             User user = userDAO.findById(userId);
//		             // Créer un objet Ticket avec les données récupérées
//		             Ticket ticket = new Ticket(event, user, price, status);
//		             ticket.setId(id);
//		             return ticket;
//		         }
//		     } catch (SQLException e) {
//		         e.printStackTrace();
//		     }
//		     return null;
//		 }
//
//	 // Méthode pour rechercher tous les tickets
//		 public List<Ticket> findAll() {
//		     List<Ticket> tickets = new ArrayList<>();
//		     String query = "SELECT * FROM tickets ";
//		     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//		         ResultSet rs = pstmt.executeQuery();
//		         while (rs.next()) {
//		             Long id = rs.getLong("id");
//		             Long eventId = rs.getLong("event_id");
//		             Long userId = rs.getLong("user_id");
//		             double price = rs.getDouble("price");
//		             String status = rs.getString("status");
//		             // Créer une instance d'EventDAO en passant la connexion
//		             EventDAO eventDAO = new EventDAO(connection);
//		             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
//		             Event event = eventDAO.findEventById(eventId);
//		             // Créer une instance de UserDAO en passant la connexion
//		             UserDAO userDAO = new UserDAO(connection);
//		             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
//		             User user = userDAO.findById(userId);
//		             // Créer un objet Ticket avec les données récupérées
//		             Ticket ticket = new Ticket(event, user, price, status);
//		             ticket.setId(id);
//		             tickets.add(ticket);
//		         }
//		     } catch (SQLException e) {
//		         e.printStackTrace();
//		     }
//		     return tickets;
//		 }
//	// Méthode pour rechercher tous les tickets avec un statut spécifique
//		 public List<Ticket> findAllByStatus(String status) {
//		     List<Ticket> tickets = new ArrayList<>();
//		     String query = "SELECT * FROM tickets WHERE status = ?";
//		     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//		         pstmt.setString(1, status);
//		         ResultSet rs = pstmt.executeQuery();
//		         while (rs.next()) {
//		             Long id = rs.getLong("id");
//		             Long eventId = rs.getLong("event_id");
//		             Long userId = rs.getLong("user_id");
//		             double price = rs.getDouble("price");
//		             String description = rs.getString("description"); // Ajout de la récupération de la description
//		             // Créer une instance d'EventDAO en passant la connexion
//		             EventDAO eventDAO = new EventDAO(connection);
//		             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
//		             Event event = eventDAO.findEventById(eventId);
//		             // Créer une instance de UserDAO en passant la connexion
//		             UserDAO userDAO = new UserDAO(connection);
//		             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
//		             User user = userDAO.findById(userId);
//		             // Créer un objet Ticket avec les données récupérées
//		             Ticket ticket = new Ticket(event, user, price, description); // Utilisation de la description récupérée depuis la base de données
//		             ticket.setId(id);
//		             tickets.add(ticket);
//		         }
//		     } catch (SQLException e) {
//		         e.printStackTrace();
//		     }
//		     return tickets;
//		 }
//			// Méthode pour rechercher tous les tickets associés à un utilisateur
//		    public List<Ticket> findAllByUser(long userId) {
//		        List<Ticket> tickets = new ArrayList<>();
//		        String query = "SELECT * FROM tickets WHERE user_id = ?";
//		        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//		            pstmt.setLong(1, userId);
//		            ResultSet rs = pstmt.executeQuery();
//		            while (rs.next()) {
//		                // Récupérer les données du ticket
//		                long ticketId = rs.getLong("id");
//		                long eventId = rs.getLong("event_id");
//		                double price = rs.getDouble("price");
//		                String status = rs.getString("status");
//		                // Instancier un objet EventDAO pour récupérer l'événement associé au ticket
//		                EventDAO eventDAO = new EventDAO(connection);
//		                Event event = eventDAO.findEventById(eventId);
//		                // Instancier un objet UserDAO pour récupérer l'utilisateur associé au ticket
//		                UserDAO userDAO = new UserDAO(connection);
//		                User user = userDAO.findById(userId);
//		                // Créer un objet Ticket avec les données récupérées
//		                Ticket ticket = new Ticket(event, user, price, status);
//		                ticket.setId(ticketId);
//		                // Ajouter le ticket à la liste
//		                tickets.add(ticket);
//		            }
//		        } catch (SQLException e) {
//		            e.printStackTrace();
//		        }
//		        return tickets;
//		    }
//	    public int countPendingTickets() {
//	        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'pending'";
//	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//	            ResultSet rs = pstmt.executeQuery();
//	            if (rs.next()) {
//	                return rs.getInt(1);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return 0;
//	    }
//
//	    public int countBookedTickets() {
//	        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'booked'";
//	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//	            ResultSet rs = pstmt.executeQuery();
//	            if (rs.next()) {
//	                return rs.getInt(1);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return 0;
//	    }
//
//}
package dao;

import Models.Event;
import Models.Ticket;
import Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

	private Connection connection;
	public TicketDAO(Connection connection) {
       this.connection = connection;
	}


	public Ticket save(Ticket ticket) {
	    String query = "INSERT INTO tickets (event_id, user_id, price, status) VALUES (?, ?, ?, ?)";

	    // Use the overloaded version of prepareStatement to specify that you want the generated keys to be returned
	    try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	        pstmt.setLong(1, ticket.getEvent().getId());
	        pstmt.setLong(2, ticket.getUser().getId());
	        pstmt.setDouble(3, ticket.getPrice());
	        pstmt.setString(4, ticket.getStatus().toString());

	        int affectedRows = pstmt.executeUpdate();

	        if (affectedRows > 0) {
	            // Retrieve the generated ID
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    // Set the retrieved ID to the ticket object
	                    ticket.setId(generatedKeys.getLong(1)); // Assuming the ID column is of type BIGINT
	                } else {
	                    throw new SQLException("Creating ticket failed, no ID obtained.");
	                }
	            }
	            System.out.println("Ticket saved with ID: " + ticket.getId());
	            return ticket;
	        } else {
	            return null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Exception: " + e.getMessage());
	        return null;
	    }
	}
	
	 public boolean updateStatus(Long ticketId, String status) {
	        String query = "UPDATE tickets SET status = ? WHERE id = ?";

	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setString(1, status);
	            pstmt.setLong(2, ticketId);

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Ticket status updated for ID: " + ticketId);
	                return true;
	            } else {
	                System.out.println("No ticket was updated. Check if the ID is correct.");
	                return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("SQL Exception: " + e.getMessage());
	            return false;
	        }
	    }


	// Méthode pour rechercher un ticket par son ID
	 public Ticket findById(Long id) {
	     String query = "SELECT * FROM tickets WHERE id = ?";
	     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	         pstmt.setLong(1, id);
	         ResultSet rs = pstmt.executeQuery();
	         if (rs.next()) {
	             Long eventId = rs.getLong("event_id");
	             Long userId = rs.getLong("user_id");
	             double price = rs.getDouble("price");
	             String status = rs.getString("status");
	             // Créer une instance d'EventDAO en passant la connexion
	             EventDAO eventDAO = new EventDAO(connection);
	             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
	             Event event = eventDAO.findEventById(eventId);
	             // Créer une instance de UserDAO en passant la connexion
	             UserDAO userDAO = new UserDAO(connection);
	             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
	             User user = userDAO.findById(userId);
	             // Créer un objet Ticket avec les données récupérées
	             Ticket ticket = new Ticket(event, user, price, status);
	             ticket.setId(id);
	             return ticket;
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return null;
	 }

	 // Méthode pour rechercher tous les tickets
	 public List<Ticket> findAll() {
	     List<Ticket> tickets = new ArrayList<>();
	     String query = "SELECT * FROM tickets ";
	     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	             Long id = rs.getLong("id");
	             Long eventId = rs.getLong("event_id");
	             Long userId = rs.getLong("user_id");
	             double price = rs.getDouble("price");
	             String status = rs.getString("status");
	             // Créer une instance d'EventDAO en passant la connexion
	             EventDAO eventDAO = new EventDAO(connection);
	             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
	             Event event = eventDAO.findEventById(eventId);
	             // Créer une instance de UserDAO en passant la connexion
	             UserDAO userDAO = new UserDAO(connection);
	             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
	             User user = userDAO.findById(userId);
	             // Créer un objet Ticket avec les données récupérées
	             Ticket ticket = new Ticket(event, user, price, status);
	             ticket.setId(id);
	             tickets.add(ticket);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return tickets;
	 }
	// Méthode pour rechercher tous les tickets avec un statut spécifique
	 public List<Ticket> findAllByStatus(String status) {
	     List<Ticket> tickets = new ArrayList<>();
	     String query = "SELECT * FROM tickets WHERE status = ?";
	     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	         pstmt.setString(1, status);
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	             Long id = rs.getLong("id");
	             Long eventId = rs.getLong("event_id");
	             Long userId = rs.getLong("user_id");
	             double price = rs.getDouble("price");
	             String description = rs.getString("description"); // Ajout de la récupération de la description
	             // Créer une instance d'EventDAO en passant la connexion
	             EventDAO eventDAO = new EventDAO(connection);
	             // Utiliser la méthode findById de EventDAO pour récupérer l'événement
	             Event event = eventDAO.findEventById(eventId);
	             // Créer une instance de UserDAO en passant la connexion
	             UserDAO userDAO = new UserDAO(connection);
	             // Utiliser la méthode findById de UserDAO pour récupérer l'utilisateur
	             User user = userDAO.findById(userId);
	             // Créer un objet Ticket avec les données récupérées
	             Ticket ticket = new Ticket(event, user, price, description); // Utilisation de la description récupérée depuis la base de données
	             ticket.setId(id);
	             tickets.add(ticket);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return tickets;
	 }

	// Méthode pour rechercher tous les tickets associés à un utilisateur
	    public List<Ticket> findAllByUser(long userId) {
	        List<Ticket> tickets = new ArrayList<>();
	        String query = "SELECT * FROM tickets WHERE user_id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setLong(1, userId);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                // Récupérer les données du ticket
	                long ticketId = rs.getLong("id");
	                long eventId = rs.getLong("event_id");
	                double price = rs.getDouble("price");
	                String status = rs.getString("status");
	                // Instancier un objet EventDAO pour récupérer l'événement associé au ticket
	                EventDAO eventDAO = new EventDAO(connection);
	                Event event = eventDAO.findEventById(eventId);
	                // Instancier un objet UserDAO pour récupérer l'utilisateur associé au ticket
	                UserDAO userDAO = new UserDAO(connection);
	                User user = userDAO.findById(userId);
	                // Créer un objet Ticket avec les données récupérées
	                Ticket ticket = new Ticket(event, user, price, status);
	                ticket.setId(ticketId);
	                // Ajouter le ticket à la liste
	                tickets.add(ticket);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return tickets;
	    }
	    public int countPendingTickets() {
	        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'pending'";
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

	    public int countBookedTickets() {
	        String query = "SELECT COUNT(*) FROM tickets WHERE status = 'booked'";
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
