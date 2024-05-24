package org.example.canteen.model;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private int dishId;
    private Date orderDate;
    private int quantity;
    private double totalPrice;

    public Order(int id, int userId, int dishId, Date orderDate, int quantity, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.dishId = dishId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
