public class CreditCardPayment implements PaymentProcessor {
    
    @Override
    public void processPayment(Order order)
    {
        System.out.println("Processing credit card payment for order id: " + order.id);
        System.out.println("Total amount: " + order.totalPrice);
        System.out.println("Credit card payment processed successfully.");
    }
}
