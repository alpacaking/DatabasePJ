package org.example.canteen.dao;

import org.example.canteen.model.Merchant;
import org.example.canteen.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MerchantDao {
    public Merchant findByUserId(int userId) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM merchants WHERE user_id = ?")) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Merchant(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("user_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDish(String name, double price, String category, String description, String imageUrl, int merchantId) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO dishes (name, price, category, description, image_url, merchant_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setString(3, category);
            statement.setString(4, description);
            statement.setString(5, imageUrl);
            statement.setInt(6, merchantId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDish(int dishId) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM dishes WHERE id = ?")) {
            statement.setInt(1, dishId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMerchant(String name, String address, int userId) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO merchants (name, address, user_id) VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMerchant(int merchantId) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM merchants WHERE id = ?")) {
            statement.setInt(1, merchantId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
