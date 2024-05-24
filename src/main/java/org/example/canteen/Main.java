package org.example.canteen;

import org.example.canteen.service.UserService;
import org.example.canteen.service.MerchantService;
import org.example.canteen.service.AdminService;
import org.example.canteen.service.OrderService;
import org.example.canteen.util.DatabaseUtil;

import java.util.Scanner;

public class Main {
    private static UserService userService = new UserService();
    private static MerchantService merchantService;
    private static AdminService adminService = new AdminService();
    private static OrderService orderService;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//       TODO DatabaseUtil.initializeDatabase();

        while (true) {
            System.out.println("请选择您的角色: 1. 用户 2. 商家 3. 管理员 0. 退出");
            int roleChoice = scanner.nextInt();

            switch (roleChoice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    merchantLogin();
                    break;
                case 3:
                    adminLogin();
                    break;
                case 0:
                    System.out.println("退出系统");
                    System.exit(0);
                default:
                    System.out.println("无效选择，请重试。");
            }
        }
    }

    private static void userLogin() {
        System.out.print("请输入用户名: ");
        String username = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        if (userService.login(username, password, "student")) {
            userOperations();
        } else {
            System.out.println("登录失败");
        }
    }

    private static void merchantLogin() {
        System.out.print("请输入用户名: ");
        String username = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        if (userService.login(username, password, "merchant")) {
            merchantOperations();
        } else {
            System.out.println("登录失败");
        }
    }

    private static void adminLogin() {
        System.out.print("请输入用户名: ");
        String username = scanner.next();
        System.out.print("请输入密码: ");
        String password = scanner.next();
        if (userService.login(username, password, "admin")) {
            adminOperations();
        } else {
            System.out.println("登录失败");
        }
    }

    private static void userOperations() {
        while (true) {
            System.out.println("用户操作菜单:");
            System.out.println("1. 查看个人信息");
            System.out.println("2. 修改密码");
            System.out.println("3. 搜索商户");
            System.out.println("4. 浏览商户详细信息");
            System.out.println("5. 搜索菜品");
            System.out.println("6. 查看菜品详细信息");
            System.out.println("7. 点餐");
            System.out.println("8. 收藏商户和菜品");
            System.out.println("9. 查看消息列表");
            System.out.println("10. 评价商品");
            System.out.println("0. 退出登录");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userService.viewUserInfo();
                    break;
                case 2:
                    userService.changePassword();
                    break;
                case 3:
                    merchantService.searchMerchants();
                    break;
                case 4:
                    merchantService.viewMerchantDetails();
                    break;
                case 5:
                    merchantService.searchDishes();
                    break;
                case 6:
                    merchantService.viewDishDetails();
                    break;
                case 7:
                    orderService.placeOrder();
                    break;
                case 8:
                    userService.manageFavorites();
                    break;
                case 9:
                    userService.viewMessages();
                    break;
                case 10:
                    userService.reviewItems();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重试。");
            }
        }
    }

    private static void merchantOperations() {
        while (true) {
            System.out.println("商家操作菜单:");
            System.out.println("1. 查看商户信息");
            System.out.println("2. 发布/管理菜单");
            System.out.println("0. 退出登录");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    merchantService.viewMerchantDetails();
                    break;
                case 2:
                    merchantService.manageMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重试。");
            }
        }
    }

    private static void adminOperations() {
        while (true) {
            System.out.println("管理员操作菜单:");
            System.out.println("1. 管理用户");
            System.out.println("2. 管理商户");
            System.out.println("0. 退出登录");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminService.manageUsers();
                    break;
                case 2:
                    adminService.manageMerchants();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重试。");
            }
        }
    }
}
