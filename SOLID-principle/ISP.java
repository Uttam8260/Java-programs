//Interface Segregation Principle:-says that if a client should not be forced to create multiple method.If client don't require why should he/she use this method .For that purpose we use Interface segregation principle.

public class ISP {

    // Segregated Interfaces
    static interface Printer {
        void print();
    }

    static interface Scanner {
        void scan();
    }

    static interface Fax {
        void fax();
    }

    static interface Copier {
        void copy();
    }

    // Class that only implements what it needs
    static class OldPrinter implements Printer {
        public void print() {
            System.out.println("OldPrinter: Printing only...");
        }
    }

    // Class that implements all functionalities
    static class ModernPrinter implements Printer, Scanner, Fax, Copier {
        public void print() {
            System.out.println("ModernPrinter: Printing...");
        }

        public void scan() {
            System.out.println("ModernPrinter: Scanning...");
        }

        public void fax() {
            System.out.println("ModernPrinter: Faxing...");
        }

        public void copy() {
            System.out.println("ModernPrinter: Copying...");
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Printer basic = new OldPrinter();
        basic.print();

        System.out.println("------------------");

        ModernPrinter modern = new ModernPrinter();
        modern.print();
        modern.scan();
        modern.fax();
        modern.copy();
    }
}
