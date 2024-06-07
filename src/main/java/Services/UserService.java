package Services;

import java.util.List;
import Models.User;
import dao.UserDAO;



public class UserService {

    private UserDAO userDAO;


    public UserService() {
    	
    }
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Boolean registerUser(User user) {
       return userDAO.save(user);
    }
    
    public User validateUser(String email, String password) {
        return userDAO.findUserByEmailAndPassword(email, password);
    }

    public User getUserById(Long id) {
        return userDAO.findById(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
    
    public List<String> getAllUserEmails(){
    	return userDAO.findAllUserEmails();
    }  
}
