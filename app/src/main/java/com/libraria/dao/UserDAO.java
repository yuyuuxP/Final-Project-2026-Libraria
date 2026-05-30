package com.libraria.dao;

import com.libraria.database.DatabaseConnection;
import java.sql.*;
import com.libraria.models.Member;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DatabaseConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean register(Member member) {
        String sql = "INSERT INTO users (email, password, secretquestion, secretanswer) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getEmail());
            statement.setString(2, member.getPassword());
            statement.setString(3, member.getSecretquestion());
            statement.setString(4, member.getSecretanswer());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean login(Member member) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getEmail());
            statement.setString(2, member.getPassword());
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getSecretQuestion(Member member) {
        String sql = "SELECT secretquestion FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getEmail());
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

    public boolean isSecretAnswerExists(Member member) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND LOWER(secretanswer) = LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getEmail());
            statement.setString(2, member.getSecretanswer());
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean changePassword(Member member) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getPassword());
            statement.setString(2, member.getEmail());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getUsersRole(String email) {
        String sql = "SELECT role FROM users WHERE email = ?";
        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("role");
            }else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}