public class ZomatoApp {

    //user class
    static class User {
        private final String name;
        private final String location;

        public User(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public String getName() {
             return name; 
            }
        public String getLocation() {
             return location; 
            }
    }

    //Resturant class
    interface Restaurant {
        void displayMenu();
        String getName();
    }

    static class IndianRestaurant implements Restaurant {
        @Override
        public void displayMenu() {
            System.out.println("Indian Menu: Biryani, Dosa, Paneer Tikka");
        }
        @Override
        public String getName() {
            return "Indian Restaurant";
        }
    }

    static class ChineseRestaurant implements Restaurant {
        @Override
        public void displayMenu() {
            System.out.println("Chinese Menu: Noodles, Manchurian, Spring Rolls");
        }
        @Override
        public String getName() {
            return "Chinese Restaurant";
        }
    }

    //factory class for resturant
    static class RestaurantFactory {
        public static Restaurant getRestaurant(String type) {
            if (type.equalsIgnoreCase("indian")) return new IndianRestaurant();
            if (type.equalsIgnoreCase("chinese")) return new ChineseRestaurant();
            throw new IllegalArgumentException("Restaurant type not supported");
        }
    }

    //order class
    static class Order {
        private final Restaurant restaurant;
        private final User user;

        public Order(Restaurant restaurant, User user) {
            this.restaurant = restaurant;
            this.user = user;
        }

        public void placeOrder() {
            System.out.println("Order placed by " + user.getName() + " at " + restaurant.getName());
            restaurant.displayMenu();
        }
    }

    //payment startegy
    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card.");
        }
    }

    static class UpiPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI.");
        }
    }

    //delivery service
    interface DeliveryService {
        void deliverOrder(String location);
    }

    static class BikeDelivery implements DeliveryService {
        @Override
        public void deliverOrder(String location) {
            System.out.println("Delivering by bike to " + location);
        }
    }

    //persistance class
    static class OrderPersistence {
        public void saveOrder(Order order) {
            System.out.println("Order saved to database.");
        }
    }

    //singleton class for app manager
    static class AppManager {
        private static final AppManager instance = new AppManager();

        private AppManager() {
            System.out.println("Zomato App Started!");
        }

        public static AppManager getInstance() {
            return instance;
        }

        public void runApp() {
            User user = new User("Uttam", "Bhubaneswar");

            Restaurant restaurant = RestaurantFactory.getRestaurant("Indian");

            Order order = new Order(restaurant, user);
            order.placeOrder();

            PaymentStrategy payment = new UpiPayment();
            payment.pay(250.0);

            PaymentStrategy payment1 = new CreditCardPayment();
            payment1.pay(350.0);

            DeliveryService delivery = new BikeDelivery();
            delivery.deliverOrder(user.getLocation());

            OrderPersistence persistence = new OrderPersistence();
            persistence.saveOrder(order);
        }
    }

    //main method to run the app
    public static void main(String[] args) {
        AppManager app = AppManager.getInstance();
        app.runApp();
    }
}
