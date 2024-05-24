package org.example.canteen.service;

import org.example.canteen.dao.OrderDao;
import org.example.canteen.dao.DishDao;
import org.example.canteen.model.Order;
import org.example.canteen.model.Dish;
import org.example.canteen.model.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private DishDao dishDao = new DishDao();
    private User loggedInUser;
    private Scanner scanner = new Scanner(System.in);

    public OrderService(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void placeOrder() {
        System.out.print("请输入菜品ID: ");
        int dishId = scanner.nextInt();
        System.out.print("请输入数量: ");
        int quantity = scanner.nextInt();
        Dish dish = dishDao.findById(dishId);
        if (dish != null) {
            double totalPrice = dish.getPrice() * quantity;
            Order order = new Order(0, loggedInUser.getId(), dishId, new Date(), quantity, totalPrice);
            orderDao.addOrder(order);
            System.out.println("订单提交成功，总价: " + totalPrice);
        } else {
            System.out.println("无效的菜品ID");
        }
    }

    public void viewOrders() {
        List<Order> orders = orderDao.getOrdersByUserId(loggedInUser.getId());
        System.out.println("您的订单记录:");
        for (Order order : orders) {
            System.out.println("订单ID: " + order.getId() + ", 菜品ID: " + order.getDishId() +
                    ", 数量: " + order.getQuantity() + ", 总价: " + order.getTotalPrice() +
                    ", 日期: " + order.getOrderDate());
        }
    }
}
