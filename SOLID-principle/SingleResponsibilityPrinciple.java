public class SingleResponsibilityPrinciple{

    static class Invoice {
    private final String item;
    private final int quantity;
    private final double price;

    public Invoice(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotal() {
        return quantity * price;
    }

    // Getters
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; } 

    }

    static class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Price: $" + invoice.getPrice());
        System.out.println("Total: $" + invoice.calculateTotal());
        }
    }
    
    static class InvoiceSaver {
    public void saveToFile(Invoice invoice, String filename) {
        // Save logic (just dummy output here)
        System.out.println("Saving invoice for " + invoice.getItem() + " to " + filename);
    }
}

    public static void main(String[] args) {
        Invoice invoice = new Invoice("Laptop", 2, 750.00);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        InvoiceSaver saver = new InvoiceSaver();
        saver.saveToFile(invoice, "invoice.txt");
    }
}