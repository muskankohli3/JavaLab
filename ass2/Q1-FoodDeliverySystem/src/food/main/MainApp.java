package food.main;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.model.RegularOrder;
import food.service.OrderService;

public class MainApp {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Aman Sharma", 500.0);
        orders[1] = new PremiumOrder(102, "Riya Kapoor", 1200.0);
        orders[2] = new RegularOrder(103, "Karan Mehta", 350.0);
        orders[3] = new PremiumOrder(104, "Simran Kaur", 900.0);
        orders[4] = new RegularOrder(105, "Rohit Verma", 620.0);
        orders[5] = new PremiumOrder(106, "Neha Gupta", 1500.0);

        OrderService orderService = new OrderService();

        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println("=================================================");

        for (FoodOrder order : orders) {
            orderService.processAndDisplayOrder(order);
        }

        System.out.println("=================================================");
        FoodOrder.displayTotalOrders();
    }
}
