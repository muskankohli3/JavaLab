package food.model;

public class RegularOrder extends FoodOrder implements Discountable {

    private static final double DELIVERY_CHARGE = 80.0;
    private static final double DISCOUNT_RATE = 0.10;

    public RegularOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return DELIVERY_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return getAmount() * DISCOUNT_RATE;
    }
}
