package food.model;

public class PremiumOrder extends FoodOrder implements Discountable {

    private static final double DELIVERY_CHARGE = 50.0;
    private static final double DISCOUNT_RATE = 0.15;

    public PremiumOrder(int orderId, String customerName, double amount) {
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
