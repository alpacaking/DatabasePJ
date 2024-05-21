package org.example.canteen.controller;

import java.util.Scanner;
import org.example.canteen.service.AdminService;

public class AdminController {
    private Scanner scanner;
    private AdminService adminService;

    public AdminController(Scanner scanner) {
        this.scanner = scanner;
        this.adminService = new AdminService(scanner);
    }

    public void handleAdminActions() {
        while (true) {
            System.out.println("Admin actions:");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Merchants");
            System.out.println("3. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminService.manageUsers();
                    break;
                case 2:
                    adminService.manageMerchants();
                    break;
                case 3:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
