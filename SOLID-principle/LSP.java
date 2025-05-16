//Liksov Substitution Principle :-Subtypes must be substitutable for their base types without altering the correctness of the program.
public class LSP{

    // Parent class or interface
    static abstract class Document {
        abstract void read();
    }

    // Subclasses following the contract properly
    static class PdfDocument extends Document {
        @Override
        public void read() {
            System.out.println("Reading PDF document...");
        }
    }

    static class WordDocument extends Document {
        @Override
        public void read() {
            System.out.println("Reading Word document...");
        }
    }

    static class ExcelDocument extends Document {
        @Override
        public void read() {
            System.out.println("Reading Excel document...");
        }
    }

    // A method that reads any document
    static void openDocument(Document doc) {
        doc.read();
    }

    // Main method
    public static void main(String[] args) {
        Document pdf = new PdfDocument();
        Document word = new WordDocument();
        Document excel = new ExcelDocument();

        // All of these should work without breaking behavior
        openDocument(pdf);
        openDocument(word);
        openDocument(excel);
    }
}
