package com.libraria.dao;

import com.libraria.database.DatabaseConnection;
import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DatabaseConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean register(String username, String password, String secretquestion, String secretanswer) {
        String sql = "INSERT INTO users (username, password, secretquestion, secretanswer) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, secretquestion);
            statement.setString(4, secretanswer);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isUserExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            return result.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getSecretQuestion(String username) {
        String sql = "SELECT secretquestion FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("secretquestion");
            }else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isSecretAnswerExists(String username, String secretanswer) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND LOWER(secretanswer) = LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, secretanswer);
            ResultSet result = statement.executeQuery();
            return result.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean changePassword(String username, String password) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, username);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}