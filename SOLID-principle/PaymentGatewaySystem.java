public class PaymentGatewaySystem {

    // --- Model Class ---
    static class PaymentRequest {
        String sender;
        String receiver;
        String currency;
        double amount;

        public PaymentRequest(String sender, String receiver, String currency, double amount) {
            this.sender = sender;
            this.receiver = receiver;
            this.currency = currency;
            this.amount = amount;
        }
    }

    // --- Strategy Interface ---
    interface PaymentGateway {
        void makePayment(PaymentRequest request);
    }

    // --- Concrete Gateway Implementations ---
    static class PayPalGateway implements PaymentGateway {
        @Override
        public void makePayment(PaymentRequest request) {
            System.out.println("PayPal: ₹ " + request.amount + " sent from " + request.sender + " to " + request.receiver + " in " + request.currency);
        }
    }

    static class PaytmGateway implements PaymentGateway {

        @Override
        public void makePayment(PaymentRequest request) {
            System.out.println("Paytm: ₹ " + request.amount + " sent from " + request.sender + " to " + request.receiver + " in " + request.currency);
        }
    }

    static class RazorpayGateway implements PaymentGateway {
        @Override
        public void makePayment(PaymentRequest request) {
            System.out.println("Razorpay: ₹ " + request.amount + " sent from " + request.sender + " to " + request.receiver + " in " + request.currency);
        }
    }

    // --- Factory to Return Gateway ---
    static class BankingSystemGatewayFactory {
        public static PaymentGateway getGateway(String gatewayName) {
            switch (gatewayName.toLowerCase()) {
                case "paypal" -> {
                    return new PayPalGateway();
                }
                case "paytm" -> {
                    return new PaytmGateway();
                }
                case "razorpay" -> {
                    return new RazorpayGateway();
                }
                default -> throw new IllegalArgumentException("Unsupported gateway: " + gatewayName);
            }
        }
    }

    // --- Proxy for Logging / Security ---
    static class PaymentGatewayProxy implements PaymentGateway {
        private final PaymentGateway realGateway;

        public PaymentGatewayProxy(PaymentGateway gateway) {
            this.realGateway = gateway;
        }

        @Override
        public void makePayment(PaymentRequest request) {
            // Logging
            System.out.println("[Proxy] Logging Payment: " + request.sender + " -> " + request.receiver + ", ₹" + request.amount);
            // Security checks could be added here
            realGateway.makePayment(request);
        }
    }

    // --- Service to Handle Business Logic ---
    static class PaymentService {
        public void processPayment(PaymentRequest request, String gatewayName) {
            PaymentGateway gateway = BankingSystemGatewayFactory.getGateway(gatewayName);
            PaymentGateway proxy = new PaymentGatewayProxy(gateway);
            proxy.makePayment(request);
        }
    }

    // --- Controller to Receive User Input / API Calls ---
    static class PaymentController {
        private final PaymentService service = new PaymentService();

        public void createPayment(String sender, String receiver, String currency, double amount, String gateway) {
            PaymentRequest request = new PaymentRequest(sender, receiver, currency, amount);
            service.processPayment(request, gateway);
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        PaymentController controller = new PaymentController();

        controller.createPayment("Uttam", "Amazon", "INR", 2500.00, "PayPal");
        controller.createPayment("Pritam", "Flipkart", "INR", 3999.00, "Paytm");
        controller.createPayment("Sritam", "Myntra", "INR", 999.00, "Razorpay");
    }
}
