public class OrderService {
    PaymentProcessor paymentProcessor;
    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void placeOrder(Order order) {
        // Process payment
        paymentProcessor.processPayment(order);
        // Additional order processing logic can be added here
        System.out.println("Order placed successfully for order id: " + order.id);
    }
}
