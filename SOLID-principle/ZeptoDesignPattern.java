// A complete Java-based Zepto-style Quick-Commerce System Design with SOLID and Design Patterns

import java.util.*;

public class ZeptoDesignPattern {

    // --- User ---
    static class User {
        String name;
        Cart cart;
        public User(String name) {
            this.name = name;
            this.cart = new Cart();
        }
    }

    // --- Cart ---
    static class Cart {
        private final Map<Product, Integer> items = new HashMap<>();
        public void addItem(Product p, int qty) {
            items.put(p, items.getOrDefault(p, 0) + qty);
            System.out.println("Added " + qty + " of " + p.name + " to cart.");
        }
        public Map<Product, Integer> getItems() {
            return items;
        }
    }

    // --- Product ---
    static class Product {
        @SuppressWarnings("unused")
                String id;
        String name;
        @SuppressWarnings("unused")
        int price;
        public Product(String id, String name, int price) {
            this.id = id; this.name = name; this.price = price;
        }

        public Product() {
        }
    }

    // --- ProductFactory ---
    static class ProductFactory {
        private static final Map<String, Product> catalog = new HashMap<>();
        public static Product createProduct(String id, String name, int price) {
            if (!catalog.containsKey(id)) {
                Product p = new Product(id, name, price);
                catalog.put(id, p);
                System.out.println("Product created: " + name + " (id=" + id + ")");
            }
            return catalog.get(id);
        }
    }

    // --- Order ---
    static class Order {
        User user;
        @SuppressWarnings("unused")
        Cart cart;
        @SuppressWarnings("unused")
        DarkStore store;
        @SuppressWarnings("unused")
        DeliveryAgent agent;
        public Order(User user, Cart cart) {
            this.user = user; this.cart = cart;
        }
    }

    // --- OrderManager ---
    static class OrderManager {
        public static Order placeOrder(User user) {
            System.out.println("Placing order for user: " + user.name);
            boolean ok = InventoryManager.checkAndReserve(user.cart);
            if (!ok) {
                System.out.println("Order failed: insufficient stock");
                return null;
            }
            DarkStore store = DarkStoreManager.assignStore(user, user.cart);
            if (store == null) {
                System.out.println("Order failed: no store available");
                return null;
            }
            Order order = new Order(user, user.cart);
            order.store = store;
            System.out.println("Order confirmed! Store: " + store.name);
            DeliveryAgent agent = DeliveryAgent.assignAgent();
            if (agent != null) {
                order.agent = agent;
                System.out.println("Assigned Delivery Agent: " + agent.name);
                agent.deliver(order);
            }
            return order;
        }
    }

    // --- DeliveryAgent ---
    static class DeliveryAgent {
        String name;
        boolean available = true;
        private static final List<DeliveryAgent> pool = new ArrayList<>();
        static {
            pool.add(new DeliveryAgent("Agent A"));
            pool.add(new DeliveryAgent("Agent B"));
        }
        public DeliveryAgent(String name) { this.name = name; }
        public static DeliveryAgent assignAgent() {
            for (DeliveryAgent a : pool) {
                if (a.available) {
                    a.available = false;
                    return a;
                }
            }
            return null;
        }
        public void deliver(Order order) {
            System.out.println(name + " is delivering order for user: " + order.user.name);
            available = true;
            System.out.println(name + " completed delivery.");
        }
    }

    // --- DarkStore ---
    static class DarkStore {
        @SuppressWarnings("unused")
                String id;
        String name;
        Map<Product, Integer> inventory = new HashMap<>();
        public DarkStore(String id, String name) {
            this.id = id; this.name = name;
        }
        public void addProduct(Product p, int qty) {
            inventory.put(p, inventory.getOrDefault(p, 0) + qty);
            System.out.println("Store " + name + " stocked with " + qty + " of " + p.name);
        }
        public boolean reserve(Cart cart) {
            for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                int have = inventory.getOrDefault(entry.getKey(), 0);
                if (have < entry.getValue()) return false;
            }
            for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                Product p = entry.getKey();
                int need = entry.getValue();
                inventory.put(p, inventory.get(p) - need);
                System.out.println("Reserved " + need + " of " + p.name + " at store " + name);
            }
            return true;
        }
    }

    // --- DarkStoreManager ---
    static class DarkStoreManager {
        private static final List<DarkStore> stores = new ArrayList<>();
        public static void registerStore(DarkStore store) {
            stores.add(store);
        }
        public static DarkStore assignStore(User user, Cart cart) {
            for (DarkStore s : stores) {
                if (s.reserve(cart)) return s;
            }
            return null;
        }
    }

    // --- InventoryManager ---
    static class InventoryManager {
        private static final InventoryStore store = new DBInventoryStore();
        public static boolean checkAndReserve(Cart cart) {
            return store.reserveInventory(cart.getItems());
        }
        public static void addStock(Product p, int qty) {
            store.addInventory(p, qty);
        }
    }

    // --- InventoryStore (interface) ---
    interface InventoryStore {
        boolean reserveInventory(Map<Product, Integer> items);
        void addInventory(Product p, int qty);
    }

    // --- DBInventoryStore ---
    static class DBInventoryStore implements InventoryStore {
        private final Map<Product, Integer> inventory = new HashMap<>();
        @Override
        public boolean reserveInventory(Map<Product, Integer> items) {
            for (Map.Entry<Product, Integer> e : items.entrySet()) {
                if (inventory.getOrDefault(e.getKey(), 0) < e.getValue()) {
                    return false;
                }
            }
            for (Map.Entry<Product, Integer> e : items.entrySet()) {
                Product p = e.getKey();
                int need = e.getValue();
                inventory.put(p, inventory.get(p) - need);
                System.out.println("InventoryManager: reserved " + need + " of " + p.name);
            }
            return true;
        }
        @Override
        public void addInventory(Product p, int qty) {
            inventory.put(p, inventory.getOrDefault(p, 0) + qty);
            System.out.println("InventoryManager: added " + qty + " of " + p.name);
        }
    }

    // --- main method ---
    public static void main(String[] args) {
        Product apple = ProductFactory.createProduct("P1", "Apple", 100);
        Product banana = ProductFactory.createProduct("P2", "Banana", 30);

        InventoryManager.addStock(apple, 10);
        InventoryManager.addStock(banana, 10);

        DarkStore ds1 = new DarkStore("DS1", "Downtown Store");
        DarkStore ds2 = new DarkStore("DS2", "Uptown Store");
        DarkStoreManager.registerStore(ds1);
        DarkStoreManager.registerStore(ds2);
        ds1.addProduct(apple, 10);
        ds1.addProduct(banana, 5);
        ds2.addProduct(apple, 5);
        ds2.addProduct(banana, 5);

        User alice = new User("Alice");
        alice.cart.addItem(apple, 3);
        alice.cart.addItem(banana, 4);

        Order order = OrderManager.placeOrder(alice);
        if (order != null) {
            System.out.println("Order completed for user: " + order.user.name);
        }
    }
}