package org.example.canteen.service;

import java.util.Scanner;

public class UserService {
    private Scanner scanner;

    public UserService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void viewAccountInfo() {
        // Implement view account info logic
        System.out.println("Viewing account information...");
    }

    public void searchMerchants() {
        // Implement search merchants logic
        System.out.println("Searching merchants...");
    }

    public void searchDishes() {
        // Implement search dishes logic
        System.out.println("Searching dishes...");
    }

    public void placeOrder() {
        // Implement place order logic
        System.out.println("Placing order...");
    }

    public void viewOrders() {
        // Implement view orders logic
        System.out.println("Viewing orders...");
    }

    public void favoriteMerchantsDishes() {
        // Implement favorite merchants and dishes logic
        System.out.println("Favoriting merchants and dishes...");
    }

    public void viewMessages() {
        // Implement view messages logic
        System.out.println("Viewing messages...");
    }

    public void rateDishes() {
        // Implement rate dishes logic
        System.out.println("Rating dishes...");
    }
}