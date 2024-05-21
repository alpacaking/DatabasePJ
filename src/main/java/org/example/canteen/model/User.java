package org.example.canteen.model;


public class User {
    private int id;
    private String name;
    private String gender;
    private String studentIdOrStaffId;
    private String username;
    private String password;

    // 构造函数
    public User(int id, String name, String gender, String studentIdOrStaffId, String username, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.studentIdOrStaffId = studentIdOrStaffId;
        this.username = username;
        this.password = password;
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

    public String getStudentIdOrStaffId() {
        return studentIdOrStaffId;
    }

    public void setStudentIdOrStaffId(String studentIdOrStaffId) {
        this.studentIdOrStaffId = studentIdOrStaffId;
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
}
