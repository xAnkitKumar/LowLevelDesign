import java.util.List;

public class zomato {
    public static void main(String[] args) {
        System.out.println("Welcome to Zomato!");

        User user = new User();
        user.id = 1;
        user.name = "John Doe";

        Restaurant restaurant = new Restaurant();
        restaurant.id = 1;
        restaurant.name = "Salad Point";
        MenuItem item1 = new MenuItem();
        item1.id = 1;
        item1.name = "Caesar Salad";
        item1.price = 500.0;
        MenuItem item2 = new MenuItem();
        item2.id = 2;
        item2.name = "Greek Salad";
        item2.price = 450.0;

        restaurant.menuItems = List.of(item1, item2);
        
        OrderController orderController = new OrderController();
        PaymentProcessor paymentProcessor = new UPIPayment();
        BasicDeliveryTracker deliveryTracker = new BasicDeliveryTracker();
        orderController.placeOrder(user, restaurant, restaurant.menuItems, paymentProcessor, deliveryTracker);
    }
}