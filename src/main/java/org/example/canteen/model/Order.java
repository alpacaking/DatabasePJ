package org.example.canteen.model;

public class Order {
    private int id;
    private int userId;
    private int merchantId;
    private int dishId;
    private String orderStatus;

    // Constructors, Getters, and Setters
    public Order() {}

    public Order(int id, int userId, int merchantId, int dishId, String orderStatus) {
        this.id = id;
        this.userId = userId;
        this.merchantId = merchantId;
        this.dishId = dishId;
        this.orderStatus = orderStatus;
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

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}