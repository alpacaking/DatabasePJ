package org.example.canteen.service;

import org.example.canteen.dao.UserDao;
import org.example.canteen.model.User;

import java.util.Scanner;

public class UserService {
    private UserDao userDao = new UserDao();
    private Scanner scanner = new Scanner(System.in);
    private User loggedInUser;

    public boolean login(String username, String password, String role) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null && user.getRole().equals(role)) {
            loggedInUser = user;
            return true;
        }
        return false;
    }

    public void viewUserInfo() {
        System.out.println("用户信息:");
        System.out.println("用户名: " + loggedInUser.getUsername());
        System.out.println("姓名: " + loggedInUser.getName());
        System.out.println("性别: " + loggedInUser.getGender());
        System.out.println("角色: " + loggedInUser.getRole());
        if ("student".equals(loggedInUser.getRole())) {
            System.out.println("学号: " + loggedInUser.getStudentId());
        } else if ("staff".equals(loggedInUser.getRole())) {
            System.out.println("工号: " + loggedInUser.getStaffId());
        }
    }

    public void changePassword() {
        System.out.print("请输入新密码: ");
        String newPassword = scanner.next();
        loggedInUser.setPassword(newPassword);
        userDao.updatePassword(loggedInUser);
        System.out.println("密码修改成功");
    }

    public void manageFavorites() {

        // Implement favorite management logic
        System.out.println("收藏管理:");
        System.out.println("1. 查看收藏");
        System.out.println("2. 添加收藏");
        System.out.println("3. 删除收藏");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                viewFavorites();
                break;
            case 2:
                addFavorite();
                break;
            case 3:
                deleteFavorite();
                break;
            default:
                System.out.println("无效选择，请重试。");
        }
    }

    private void viewFavorites() {

        // TODO Logic to view favorites
        System.out.println("查看收藏功能尚未实现");
    }

    private void addFavorite() {

        // TODO Logic to add a favorite
        System.out.println("添加收藏功能尚未实现");
    }

    private void deleteFavorite() {

        // TODO Logic to delete a favorite
        System.out.println("删除收藏功能尚未实现");
    }

    public void viewMessages() {

        // TODO Implement message viewing logic
        System.out.println("消息查看功能尚未实现");
    }

    public void reviewItems() {

        // TODO Implement item reviewing logic
        System.out.println("评价功能尚未实现");
    }
}
