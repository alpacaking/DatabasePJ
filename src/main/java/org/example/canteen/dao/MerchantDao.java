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
        String sql = "INSERT INTO Merchant (name, address) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, merchant.getName());
            stmt.setString(2, merchant.getAddress());
            stmt.executeUpdate();
        }
    }

    public Merchant getMerchantById(int id) throws SQLException {
        String sql = "SELECT * FROM Merchant WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Merchant(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
            } else {
                return null;
            }
        }
    }

    public List<Merchant> getAllMerchants() throws SQLException {
        String sql = "SELECT * FROM Merchant";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            List<Merchant> merchants = new ArrayList<>();
            while (rs.next()) {
                merchants.add(new Merchant(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
            }
            return merchants;
        }
    }

    public void updateMerchant(Merchant merchant) throws SQLException {
        String sql = "UPDATE Merchant SET name = ?, address = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, merchant.getName());
            stmt.setString(2, merchant.getAddress());
            stmt.setInt(3, merchant.getId());
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