package org.example.canteen.dao;


import org.example.canteen.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO User (name, gender, studentIdOrStaffId, username, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getGender());
            stmt.setString(3, user.getStudentIdOrStaffId());
            stmt.setString(4, user.getUsername());
            stmt.setString(5, user.getPassword());
            stmt.executeUpdate();
        }
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM User WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("studentIdOrStaffId"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM User WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("studentIdOrStaffId"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("studentIdOrStaffId"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE User SET name = ?, gender = ?, studentIdOrStaffId = ?, username = ?, password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getGender());
            stmt.setString(3, user.getStudentIdOrStaffId());
            stmt.setString(4, user.getUsername());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}