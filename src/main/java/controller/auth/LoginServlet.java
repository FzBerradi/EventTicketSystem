package controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import Models.User;
import Services.UserService;
import config.DatabaseUtil;
import dao.UserDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	//pour envoyer les donnees au serveur 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Connection conn = DatabaseUtil.getConnection();
        if(conn != null) {
            UserDAO userDAO = new UserDAO(conn);
            UserService userService = new UserService(userDAO);
            
            User user = userService.validateUser(email, password);
            if (user != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("user", user);//// Ajout de l'utilisateur à la session
                //request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response); 
            } else {
                String errorMessage = "Invalid email or password";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/WEB-INF/views/userLogin.jsp").forward(request, response);
            }
        } else {
            String errorMessage = "Database connection failure. Please try again later.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/WEB-INF/views/userLogin.jsp").forward(request, response);
        }
    }
    //pour recuperer les donnnes de serveur
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
			request.getRequestDispatcher("/WEB-INF/views/userLogin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}