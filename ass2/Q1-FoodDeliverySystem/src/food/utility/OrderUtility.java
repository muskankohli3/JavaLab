package food.utility;

import food.model.FoodOrder;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static String generateOrderSummary(FoodOrder order, double discount,
                                               double deliveryCharge, double finalAmount) {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------------\n");
        sb.append("Order ID        : ").append(order.getOrderId()).append("\n");
        sb.append("Customer Name   : ").append(order.getCustomerName()).append("\n");
        sb.append("Restaurant      : ").append(FoodOrder.getRestaurantName()).append("\n");
        sb.append("Order Type      : ").append(order.getClass().getSimpleName()).append("\n");
        sb.append("Bill Amount     : Rs. ").append(order.getAmount()).append("\n");
        sb.append("Discount        : Rs. ").append(discount).append("\n");
        sb.append("Delivery Charge : Rs. ").append(deliveryCharge).append("\n");
        sb.append("Final Payable   : Rs. ").append(finalAmount).append("\n");
        sb.append("-----------------------------------------------");
        return sb.toString();
    }
}
