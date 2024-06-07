package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Models.Event;
import Models.User;
import Services.UserService;
import config.DatabaseUtil;
import dao.UserDAO;

@WebServlet("/register")
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password"); 
	    
	    User user = new User(name, email, password);
	    Connection conn = DatabaseUtil.getConnection();
	    
	    if(conn != null) {
	        UserDAO userDAO = new UserDAO(conn);
	        UserService userService = new UserService(userDAO);
	          
	        boolean result = userService.registerUser(user);

	        if (result) {
	            request.getRequestDispatcher("/WEB-INF/views/userLogin.jsp").forward(request, response);
	        } else {
	            // If registration fails, set an error message and forward back to the registration page
	            String errorMessage = "Registration failed. Please try again.";
	            request.setAttribute("errorMessage", errorMessage);
	            // Assuming "register.jsp" is the path to your registration form
	            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	        }
	    } else {
	        // Handle database connection failure
	        String errorMessage = "Database connection failure. Please try again later.";
	        request.setAttribute("errorMessage", errorMessage);
	        // Assuming "register.jsp" is the path to your registration form
	        request.getRequestDispatcher("/WEB-INF/views/userRegistration.jsp").forward(request, response);
	    }
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
			request.getRequestDispatcher("/WEB-INF/views/userRegistration.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Additional methods to handle login, updating user information, etc.
}