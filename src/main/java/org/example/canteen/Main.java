package org.example.canteen;


import java.util.Scanner;
import org.example.canteen.controller.AdminController;
import org.example.canteen.controller.MerchantController;
import org.example.canteen.controller.UserController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminController adminController = new AdminController(scanner);
        MerchantController merchantController = new MerchantController(scanner);
        UserController userController = new UserController(scanner);

        System.out.println("Welcome to the Canteen Ordering System!");
        while (true) {
            System.out.println("Please select your role: ");
            System.out.println("1. User");
            System.out.println("2. Merchant");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userController.handleUserActions();
                    break;
                case 2:
                    merchantController.handleMerchantActions();
                    break;
                case 3:
                    adminController.handleAdminActions();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
