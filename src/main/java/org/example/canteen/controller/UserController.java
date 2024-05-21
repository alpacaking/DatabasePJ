package org.example.canteen.controller;

import java.util.Scanner;
import org.example.canteen.service.UserService;

public class UserController {
    private Scanner scanner;
    private UserService userService;

    public UserController(Scanner scanner) {
        this.scanner = scanner;
        this.userService = new UserService(scanner);
    }

    public void handleUserActions() {
        while (true) {
            System.out.println("User actions:");
            System.out.println("1. View Account Information");
            System.out.println("2. Search and Browse Merchants");
            System.out.println("3. Search and Browse Dishes");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Favorite Merchants/Dishes");
            System.out.println("7. View Messages");
            System.out.println("8. Rate Dishes");
            System.out.println("9. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userService.viewAccountInfo();
                    break;
                case 2:
                    userService.searchMerchants();
                    break;
                case 3:
                    userService.searchDishes();
                    break;
                case 4:
                    userService.placeOrder();
                    break;
                case 5:
                    userService.viewOrders();
                    break;
                case 6:
                    userService.favoriteMerchantsDishes();
                    break;
                case 7:
                    userService.viewMessages();
                    break;
                case 8:
                    userService.rateDishes();
                    break;
                case 9:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}