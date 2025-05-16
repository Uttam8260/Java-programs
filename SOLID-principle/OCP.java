//OpenClosedPrinciple example:-Open for extension and closed for modification
public class OCP{

    // PaymentStrategy Interface
    static interface PaymentStrategy {
        void pay(double amount);
    }

    // CreditCardPayment class
    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card.");
        }
    }

    // PayPalPayment class
    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal.");
        }
    }

    // NEW payment method: UPI (Open for extension)
    static class UpiPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI.");
        }
    }

    // PaymentProcessor class (depends on abstraction)
    static class PaymentProcessor {
        public void processPayment(PaymentStrategy strategy, double amount) {
            strategy.pay(amount);
        }
    }

    // Main Method
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Using different payment methods
        processor.processPayment(new CreditCardPayment(), 1500);
        processor.processPayment(new PayPalPayment(), 2500);
        processor.processPayment(new UpiPayment(), 1000); // New method, no modification needed
    }

}