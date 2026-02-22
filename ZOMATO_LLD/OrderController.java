import java.util.List;

public class OrderController {
    public void placeOrder(User user, Restaurant restaurant, List<MenuItem> menuItems, PaymentProcessor paymentProcessor, DeliveryTracker deliveryTracker) {
        // Create a new order
        Order order = new Order();
        order.setId(0);
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setMenuItems(menuItems);
        order.setTotalPrice(order.calculateTotalPrice(menuItems));
        // Process payment
        paymentProcessor.processPayment(order);

        // Track delivery
        deliveryTracker.trackDelivery(order);
    }
}
