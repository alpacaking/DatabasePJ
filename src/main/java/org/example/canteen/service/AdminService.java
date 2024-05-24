package org.example.canteen.service;

import org.example.canteen.dao.UserDao;
import org.example.canteen.dao.MerchantDao;
import org.example.canteen.model.User;

import java.util.Scanner;

public class AdminService {
    private UserDao userDao = new UserDao();
    private MerchantDao merchantDao = new MerchantDao();
    private Scanner scanner = new Scanner(System.in);

    public void manageUsers() {
        System.out.println("用户管理:");
        System.out.println("1. 添加用户");
        System.out.println("2. 删除用户");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                deleteUser();
                break;
            default:
                System.out.println("无效选择，请重试。");
        }
    }

    private void addUser() {
        System.out.print("请输入姓名: ");
        String name = scanner.next();
        System.out.print("请输入性别 (M/F): ");
        String gender = scanner.next();
        System.out.print("请输入角色 (student/staff/merchant/admin): ");
        String role = scanner.next();
        System.out.print("请输入用户名: ");
        String username = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        String studentId = null;
        String staffId = null;
        if ("student".equals(role)) {
            System.out.print("请输入学号: ");
            studentId = scanner.next();
        } else if ("staff".equals(role)) {
            System.out.print("请输入工号: ");
            staffId = scanner.next();
        }
        User user = new User(name, gender, role, username, password, studentId, staffId);
        userDao.addUser(user);
        System.out.println("用户添加成功");
    }

    private void deleteUser() {
        System.out.print("请输入要删除的用户名: ");
        String username = scanner.next();
        userDao.deleteUser(username);
        System.out.println("用户删除成功");
    }

    public void manageMerchants() {
        System.out.println("商户管理:");
        System.out.println("1. 添加商户");
        System.out.println("2. 删除商户");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addMerchant();
                break;
            case 2:
                deleteMerchant();
                break;
            default:
                System.out.println("无效选择，请重试。");
        }
    }

    private void addMerchant() {
        System.out.print("请输入商户名称: ");
        String name = scanner.next();
        System.out.print("请输入地址: ");
        String address = scanner.next();
        System.out.print("请输入关联的用户ID: ");
        int userId = scanner.nextInt();
        merchantDao.addMerchant(name, address, userId);
        System.out.println("商户添加成功");
    }

    private void deleteMerchant() {
        System.out.print("请输入要删除的商户ID: ");
        int merchantId = scanner.nextInt();
        merchantDao.deleteMerchant(merchantId);
        System.out.println("商户删除成功");
    }
}
