package food.model;

public abstract class FoodOrder {

    private int orderId;
    private String customerName;
    private double amount;

    private static String restaurantName = "Foodie Express";
    private static int orderCounter = 0;

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String name) {
        restaurantName = name;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + orderCounter);
    }

    public abstract double calculateDeliveryCharge();

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Bill Amount: Rs. " + amount;
    }
}
