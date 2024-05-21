package org.example.canteen.dao;

import org.example.canteen.model.Merchant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MerchantDao {
    private Connection connection;

    public MerchantDao(Connection connection) {
        this.connection = connection;
    }

    public void addMerchant(Merchant merchant) throws SQLException {
        String sql = "INSERT INTO Merchant (name, address, username, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, merchant.getName());
            stmt.setString(2, merchant.getAddress());
            stmt.setString(3, merchant.getUsername());
            stmt.setString(4, merchant.getPassword());
            stmt.executeUpdate();
        }
    }

    public Merchant getMerchantById(int id) throws SQLException {
        String sql = "SELECT * FROM Merchant WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Merchant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    public Merchant getMerchantByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM Merchant WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Merchant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    public List<Merchant> getAllMerchants() throws SQLException {
        List<Merchant> merchants = new ArrayList<>();
        String sql = "SELECT * FROM Merchant";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                merchants.add(new Merchant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        }
        return merchants;
    }

    public void updateMerchant(Merchant merchant) throws SQLException {
        String sql = "UPDATE Merchant SET name = ?, address = ?, username = ?, password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, merchant.getName());
            stmt.setString(2, merchant.getAddress());
            stmt.setString(3, merchant.getUsername());
            stmt.setString(4, merchant.getPassword());
            stmt.setInt(5, merchant.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteMerchant(int id) throws SQLException {
        String sql = "DELETE FROM Merchant WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}