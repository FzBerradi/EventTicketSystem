package observer;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import Models.Event;
import Services.UserService;
import config.DatabaseUtil;
import dao.UserDAO;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailNotification implements Observer{
	
	private List<String> recipients;
	
	@Override
    public void update(Event event) {
       
        
        // get recipients 
        Connection conn = DatabaseUtil.getConnection();
        if(conn != null) {
            UserDAO userDAO = new UserDAO(conn);
            UserService userService = new UserService(userDAO);
            this.recipients = userService.getAllUserEmails();
        }
       
	    // Subject and content of the email you will receive
	    String subject = "New Event has been Created🎟";
	 // Format the event date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(event.getDate());
        String content = "Dear Attendees,\n\n"
                + "We are pleased to announce a new event has been created in our Event Booking System:\n\n"
                + "Event Name: " + event.getName() + "\n"
                + "Location: " + event.getLocation() +  "\n"
                + "Date: " + formattedDate + "\n"
                + "Ticket Base Price: $" + event.getBasePrice() + "\n\n"
                + "Thank you for your interest. We look forward to seeing you there!\n\n"
                + "Best Regards,\n"
                + "Event Management Team";

	    // Sender's email ID (it could be your generic business support email)
     // Définition de l'adresse e-mail de l'expéditeur avec un nom personnalisé
        String senderEmail = "brdfatimazahra@gmail.com";
        String senderPassword = "djct fvrl jfdh abhh";


     // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
     // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
        	// Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(senderEmail));
      
            // Set To: header field of the header
            InternetAddress[] recipientAddresses = new InternetAddress[recipients.size()];
            for (int i = 0; i < recipients.size(); i++) {
                recipientAddresses[i] = new InternetAddress(recipients.get(i));
            }
            message.addRecipients(Message.RecipientType.TO, recipientAddresses);

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipients);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
