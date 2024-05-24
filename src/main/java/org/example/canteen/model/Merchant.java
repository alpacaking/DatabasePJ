package org.example.canteen.model;

public class Merchant {
    private int id;
    private String name;
    private String address;
    private int userId;

    // 构造函数
    public Merchant(int id, String name, String address, int userId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userId = userId;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

