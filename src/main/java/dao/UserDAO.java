package dao;
import Models.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class UserDAO {
	
	 private Connection connection;
	 public UserDAO(Connection connection) {
        this.connection = connection;
	 }



    public Boolean save(User user) {
    	String query = "INSERT INTO users(username,email, password) VALUES(?, ? , ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int countAllUsers() {
        String query = "SELECT COUNT(*) FROM users";
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
    public User findUserByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getLong("id"), rs.getString("username"), email, password, rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> findAllUserEmails() {
        List<String> userEmails = new ArrayList<>();
        String query = "SELECT email FROM users WHERE role = 'User'";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userEmails.add(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEmails;
    }
    public User findById(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(id, username, email, password,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(id, username, email, password,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                users.add(new User(id, username, email, password,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void update(User user) {
        
    }
   

    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
           // entityManager.remove(user);
        }
    }
}