public class BasicDeliveryTracker implements DeliveryTracker {

    public void trackDelivery(Order order) {
        System.out.println("Tracking delivery for order id: " + order.id);
        // Basic tracking logic
        System.out.println("Delivery is on the way!");
    }
    
}
