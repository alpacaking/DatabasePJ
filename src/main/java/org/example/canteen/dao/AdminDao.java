package org.example.canteen.dao;

import org.example.canteen.model.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private Connection connection;

    public AdminDao(Connection connection) {
        this.connection = connection;
    }

    public void addAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO Admin (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getName());
            stmt.executeUpdate();
        }
    }

    public Admin getAdminById(int id) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("name"));
            } else {
                return null;
            }
        }
    }

    public List<Admin> getAllAdmins() throws SQLException {
        String sql = "SELECT * FROM Admin";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            List<Admin> admins = new ArrayList<>();
            while (rs.next()) {
                admins.add(new Admin(rs.getInt("id"), rs.getString("name")));
            }
            return admins;
        }
    }

    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "UPDATE Admin SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getName());
            stmt.setInt(2, admin.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteAdmin(int id) throws SQLException {
        String sql = "DELETE FROM Admin WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}