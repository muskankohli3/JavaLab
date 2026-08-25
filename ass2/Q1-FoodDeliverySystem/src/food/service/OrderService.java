package food.service;

import food.model.Discountable;
import food.model.FoodOrder;
import food.utility.OrderUtility;

public class OrderService {

    public void processAndDisplayOrder(FoodOrder order) {

        if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
            System.out.println("Invalid customer name for Order ID: " + order.getOrderId());
            return;
        }

        if (!OrderUtility.validateAmount(order.getAmount())) {
            System.out.println("Invalid amount for Order ID: " + order.getOrderId());
            return;
        }

        double deliveryCharge = order.calculateDeliveryCharge();
        double discount = 0.0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double finalAmount = order.getAmount() - discount + deliveryCharge;

        String summary = OrderUtility.generateOrderSummary(order, discount, deliveryCharge, finalAmount);
        System.out.println(summary);
    }
}
