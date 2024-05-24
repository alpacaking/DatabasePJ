package org.example.canteen.dao;

import org.example.canteen.model.Dish;
import org.example.canteen.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    public void addDish(Dish dish) {
        String sql = "INSERT INTO dishes (name, price, category, description, image_url, merchant_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dish.getName());
            statement.setDouble(2, dish.getPrice());
            statement.setString(3, dish.getCategory());
            statement.setString(4, dish.getDescription());
            statement.setString(5, dish.getImageUrl());
            statement.setInt(6, dish.getMerchantId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDish(int dishId) {
        String sql = "DELETE FROM dishes WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dishId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dish findById(int dishId) {
        String sql = "SELECT * FROM dishes WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dishId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Dish(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("price"),
                            resultSet.getString("category"),
                            resultSet.getString("description"),
                            resultSet.getString("image_url"),
                            resultSet.getInt("merchant_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Dish> getDishesByMerchantId(int merchantId) {
        List<Dish> dishes = new ArrayList<>();
        String sql = "SELECT * FROM dishes WHERE merchant_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, merchantId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Dish dish = new Dish(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("price"),
                            resultSet.getString("category"),
                            resultSet.getString("description"),
                            resultSet.getString("image_url"),
                            resultSet.getInt("merchant_id")
                    );
                    dishes.add(dish);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
