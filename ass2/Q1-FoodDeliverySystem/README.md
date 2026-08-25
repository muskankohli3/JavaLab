# Online Food Delivery System

## Package Structure
- `food.model` — `FoodOrder` (abstract), `Discountable` (interface), `RegularOrder`, `PremiumOrder`
- `food.service` — `OrderService` (business logic: validation, delivery charge, discount, final amount)
- `food.utility` — `OrderUtility` (validation + summary generation helpers)
- `food.main` — `MainApp` (driver class)

## How to Compile & Run
```
cd src
javac food/model/*.java food/service/*.java food/utility/*.java food/main/*.java
java food.main.MainApp
```

## Rules Implemented
| Order Type | Delivery Charge | Discount |
|---|---|---|
| RegularOrder | Rs. 80 | 10% |
| PremiumOrder | Rs. 50 | 15% |
