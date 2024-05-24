package org.example.canteen.service;

import org.example.canteen.dao.MerchantDao;
import org.example.canteen.model.Merchant;
import org.example.canteen.model.User;

import java.util.Scanner;

public class MerchantService {
    private MerchantDao merchantDao = new MerchantDao();
    private Scanner scanner = new Scanner(System.in);
    private User loggedInUser;

    public MerchantService(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void searchMerchants() {
        // Implement merchant searching logic
        System.out.println("商户搜索功能尚未实现");
    }

    public void viewMerchantDetails() {
        // Implement merchant detail viewing logic
        System.out.println("查看商户详情功能尚未实现");
    }

    public void searchDishes() {
        // Implement dish searching logic
        System.out.println("菜品搜索功能尚未实现");
    }

    public void viewDishDetails() {
        // Implement dish detail viewing logic
        System.out.println("查看菜品详情功能尚未实现");
    }

    public void manageMenu() {
        System.out.println("菜单管理:");
        System.out.println("1. 添加菜品");
        System.out.println("2. 删除菜品");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addDish();
                break;
            case 2:
                deleteDish();
                break;
            default:
                System.out.println("无效选择，请重试。");
        }
    }

    private void addDish() {
        System.out.print("请输入菜品名称: ");
        String name = scanner.next();
        System.out.print("请输入价格: ");
        double price = scanner.nextDouble();
        System.out.print("请输入分类: ");
        String category = scanner.next();
        System.out.print("请输入描述: ");
        String description = scanner.next();
        System.out.print("请输入图片URL: ");
        String imageUrl = scanner.next();
        Merchant merchant = merchantDao.findByUserId(loggedInUser.getId());
        merchantDao.addDish(name, price, category, description, imageUrl, merchant.getId());
        System.out.println("菜品添加成功");
    }

    private void deleteDish() {
        System.out.print("请输入要删除的菜品ID: ");
        int dishId = scanner.nextInt();
        merchantDao.deleteDish(dishId);
        System.out.println("菜品删除成功");
    }

    public void manageMerchantInfo() {
        // Implement merchant information management logic
        System.out.println("商户信息管理功能尚未实现");
    }
}

