package org.example.canteen.dao;


import org.example.canteen.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO `Order` (userId, merchantId, dishId, orderStatus) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getMerchantId());
            stmt.setInt(3, order.getDishId());
            stmt.setString(4, order.getOrderStatus());
            stmt.executeUpdate();
        }
    }

    public Order getOrderById(int id) throws SQLException {
        String sql = "SELECT * FROM `Order` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("id"), rs.getInt("userId"), rs.getInt("merchantId"), rs.getInt("dishId"), rs.getString("orderStatus"));
            } else {
                return null;
            }
        }
    }

    public List<Order> getAllOrders() throws SQLException {
        String sql = "SELECT * FROM `Order`";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"), rs.getInt("userId"), rs.getInt("merchantId"), rs.getInt("dishId"), rs.getString("orderStatus")));
            }
            return orders;
        }
    }

    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE `Order` SET userId = ?, merchantId = ?, dishId = ?, orderStatus = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getMerchantId());
            stmt.setInt(3, order.getDishId());
            stmt.setString(4, order.getOrderStatus());
            stmt.setInt(5, order.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM `Order` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}