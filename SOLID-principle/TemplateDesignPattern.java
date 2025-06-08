//Client which can acsess the Templte design pattern
public class TemplateDesignPattern {

    // Abstract class defining the template
    static abstract class PaymentProcessor {

        // Template method
        public final void processPayment() {
            authenticateUser();
            validatePaymentDetails();
            makePayment();
            sendConfirmation();
        }

        protected abstract void authenticateUser();
        protected abstract void validatePaymentDetails();
        protected abstract void makePayment();

        protected void sendConfirmation() {
            System.out.println("Confirmation: Payment successful.\n");
        }
    }

    // Concrete class for PayPaljava TemplateDesignPattern
    
    static class PayPalPayment extends PaymentProcessor {
        @Override
        protected void authenticateUser() {
            System.out.println("Authenticating via PayPal account...");
        }

        @Override
        protected void validatePaymentDetails() {
            System.out.println("Validating PayPal account details...");
        }

        @Override
        protected void makePayment() {
            System.out.println("Making payment using PayPal...");
        }
    }

    // Concrete class for Credit Card
    static class CreditCardPayment extends PaymentProcessor {
        @Override
        protected void authenticateUser() {
            System.out.println("Authenticating credit card user...");
        }

        @Override
        protected void validatePaymentDetails() {
            System.out.println("Validating credit card number and CVV...");
        }

        @Override
        protected void makePayment() {
            System.out.println("Making payment using Credit Card...");
        }
    }

    // Concrete class for UPI
    static class UpiPayment extends PaymentProcessor {
        @Override
        protected void authenticateUser() {
            System.out.println("Authenticating via UPI PIN...");
        }

        @Override
        protected void validatePaymentDetails() {
            System.out.println("Validating UPI ID...");
        }

        @Override
        protected void makePayment() {
            System.out.println("Making payment using UPI...");
        }
    }

    // Client code
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalPayment();
        paypal.processPayment();

        PaymentProcessor creditCard = new CreditCardPayment();
        creditCard.processPayment();

        PaymentProcessor upi = new UpiPayment();
        upi.processPayment();
    }
}
