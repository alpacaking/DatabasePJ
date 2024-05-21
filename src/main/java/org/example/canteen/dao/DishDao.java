package org.example.canteen.dao;


import org.example.canteen.model.Dish;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    private Connection connection;

    public DishDao(Connection connection) {
        this.connection = connection;
    }

    public void addDish(Dish dish) throws SQLException {
        String sql = "INSERT INTO Dish (name, price, category, description, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dish.getName());
            stmt.setDouble(2, dish.getPrice());
            stmt.setString(3, dish.getCategory());
            stmt.setString(4, dish.getDescription());
            stmt.setString(5, dish.getImage());
            stmt.executeUpdate();
        }
    }

    public Dish getDishById(int id) throws SQLException {
        String sql = "SELECT * FROM Dish WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("description"), rs.getString("image"));
            } else {
                return null;
            }
        }
    }

    public List<Dish> getAllDishes() throws SQLException {
        String sql = "SELECT * FROM Dish";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            List<Dish> dishes = new ArrayList<>();
            while (rs.next()) {
                dishes.add(new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category"), rs.getString("description"), rs.getString("image")));
            }
            return dishes;
        }
    }

    public void updateDish(Dish dish) throws SQLException {
        String sql = "UPDATE Dish SET name = ?, price = ?, category = ?, description = ?, image = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dish.getName());
            stmt.setDouble(2, dish.getPrice());
            stmt.setString(3, dish.getCategory());
            stmt.setString(4, dish.getDescription());
            stmt.setString(5, dish.getImage());
            stmt.setInt(6, dish.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteDish(int id) throws SQLException {
        String sql = "DELETE FROM Dish WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
