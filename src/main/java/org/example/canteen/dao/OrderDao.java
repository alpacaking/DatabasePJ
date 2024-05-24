package org.example.canteen.dao;

import org.example.canteen.model.Order;
import org.example.canteen.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, dish_id, order_date, quantity, total_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getUserId());
            statement.setInt(2, order.getDishId());
            statement.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            statement.setInt(4, order.getQuantity());
            statement.setDouble(5, order.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("dish_id"),
                            resultSet.getDate("order_date"),
                            resultSet.getInt("quantity"),
                            resultSet.getDouble("total_price")
                    );
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
