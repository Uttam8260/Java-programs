import java.util.*;

// Document Element Interface (Interface Segregation, Open/Closed)
interface DocumentElement {
    void render();
}

// Concrete Document Elements
class TextElement implements DocumentElement {
    private final String text;
    public TextElement(String text) { this.text = text; }

    @Override
    public void render() {
        System.out.println("Rendering Text: " + text);
    }
}

class ImageElement implements DocumentElement {
    private final String imagePath;
    public ImageElement(String imagePath) { this.imagePath = imagePath; }

    @Override
    public void render() {
        System.out.println("Rendering Image from: " + imagePath);
    }
}

class TableElement implements DocumentElement {
    private final String[][] data;
    public TableElement(String[][] data) { this.data = data; }

    @Override
    public void render() {
        System.out.println("Rendering Table:");
        for (String[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }
}

// Document (Single Responsibility: Only holds elements)
class Document {
    private final List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }
}

// Editor (Open/Closed Principle: allows adding new element types without modifying)
class DocumentEditor {
    public void addText(Document doc, String text) {
        doc.addElement(new TextElement(text));
    }

    public void addImage(Document doc, String path) {
        doc.addElement(new ImageElement(path));
    }

    public void addTable(Document doc, String[][] table) {
        doc.addElement(new TableElement(table));
    }
}

// Renderer (Single Responsibility: only renders)
class DocumentRenderer {
    public void render(Document doc) {
        System.out.println("---- Document Start ----");
        for (DocumentElement element : doc.getElements()) {
            element.render();
        }
        System.out.println("---- Document End ----");
    }
}

// Persistence (Single Responsibility: handles saving/loading)
@SuppressWarnings("unused")
 class DocumentPersistence {
    public void save(Document doc) {
        System.out.println("Document saved to disk (mock).");
    }

    public Document load() {
        System.out.println("Loading document from disk (mock).");
        Document doc = new Document();
        doc.addElement(new TextElement("Loaded Text"));
        return doc;
    }
}

// Dependency Inversion Principle via interface
interface StorageService {
    void save(Document doc);
    Document load();
}

class FileStorageService implements StorageService {
    @Override
    public void save(Document doc) {
        System.out.println("Saving document to file system.");
    }

    @Override
    public Document load() {
        System.out.println("Loading document from file system.");
        return new Document();
    }
}

@SuppressWarnings("unused")
class CloudStorageService implements StorageService {
    @Override
    public void save(Document doc) {
        System.out.println("Saving document to cloud.");
    }

    @Override
    public Document load() {
        System.out.println("Loading document from cloud.");
        return new Document();
    }
}

// High-level module depending on abstraction
class DocumentManager {
    private final StorageService storageService;

    public DocumentManager(StorageService storageService) {
        this.storageService = storageService;
    }

    public void saveDocument(Document doc) {
        storageService.save(doc);
    }

    public Document loadDocument() {
        return storageService.load();
    }
}

// Client
public class DocumentReader_App {
    public static void main(String[] args) {
        Document doc = new Document();
        DocumentEditor editor = new DocumentEditor();
        DocumentRenderer renderer = new DocumentRenderer();

        // Add elements
        editor.addText(doc, "Hello World");
        editor.addImage(doc, "/images/logo.png");
        editor.addTable(doc, new String[][] {
            {"Name", "Age"},
            {"Alice", "30"},
            {"Bob", "25"}
        });

        // Render the document
        renderer.render(doc);

        // Persist the document using DIP
        DocumentManager manager = new DocumentManager(new FileStorageService());
        manager.saveDocument(doc);

        // Load document
        Document loadedDoc = manager.loadDocument();
        renderer.render(loadedDoc);
    }
}
