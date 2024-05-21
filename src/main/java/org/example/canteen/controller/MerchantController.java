package org.example.canteen.controller;

import java.util.Scanner;
import org.example.canteen.service.MerchantService;

public class MerchantController {
    private Scanner scanner;
    private MerchantService merchantService;

    public MerchantController(Scanner scanner) {
        this.scanner = scanner;
        this.merchantService = new MerchantService(scanner);
    }

    public void handleMerchantActions() {
        while (true) {
            System.out.println("Merchant actions:");
            System.out.println("1. View Merchant Information");
            System.out.println("2. Manage Menu and Prices");
            System.out.println("3. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    merchantService.viewMerchantInfo();
                    break;
                case 2:
                    merchantService.manageMenuAndPrices();
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
