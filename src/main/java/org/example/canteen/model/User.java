package org.example.canteen.model;

public class User {
    private int id;
    private String name;
    private String gender;
    private String role;
    private String username;
    private String password;
    private String studentId;
    private String staffId;

    // 构造函数
    public User(String name, String gender, String role, String username, String password, String studentId, String staffId) {
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.username = username;
        this.password = password;
        this.studentId = studentId;
        this.staffId = staffId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}

