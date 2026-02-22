public class UPIPayment implements PaymentProcessor {

    @Override
    public void processPayment(Order order) {
        System.out.println("Processing UPI payment for order id: " + order.id);
        System.out.println("Total amount: " + order.totalPrice);
        System.out.println("UPI payment processed successfully.");
    } 
    
}
