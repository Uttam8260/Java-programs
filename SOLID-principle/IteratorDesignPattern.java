import java.util.*;

public class IteratorDesignPattern {

    // Song
    static class Song {
        private final String title;
        public Song(String title) { this.title = title; }
        public String getTitle() { return title; }
    }

    // Playlist
    static class Playlist {
        private final List<Song> songs = new ArrayList<>();
        public void addSong(Song song) { songs.add(song); }
        public Iterator<Song> iterator() { return songs.iterator(); }
    }

    // LinkedList
    static class LinkedList<T> {
        static class Node<T> {
            T data;
            Node<T> next;
            Node(T data) { 
                this.data = data; 
            }
        }

        private Node<T> head;

        public void add(T data) {
            if (head == null) {
                head = new Node<>(data);
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node<>(data);
            }
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> current = head;
                @Override
                public boolean hasNext() {
                     return current != null;
                     }
                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }
    }

    // Binary Tree
    static class BinaryTree {
        static class Node {
            int value;
            Node left, right;
            Node(int value) { 
                this.value = value; 
            }
        }

        Node root;

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node node, int value) {
            if (node == null) return new Node(value);
            if (value < node.value) node.left = insertRec(node.left, value);
            else node.right = insertRec(node.right, value);
            return node;
        }

        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                Stack<Node> stack = new Stack<>();
                { pushLeft(root); }

                private void pushLeft(Node node) {
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }

                @Override
                public boolean hasNext() {
                    return !stack.isEmpty();
                }

                @Override
                public Integer next() {
                    Node node = stack.pop();
                    pushLeft(node.right);
                    return node.value;
                }
            };
        }
    }

    public static void main(String[] args) {
        // Playlist Iterator
        System.out.println("--- Playlist Iterator ---");
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song A"));
        playlist.addSong(new Song("Song B"));
        playlist.addSong(new Song("Song C"));

        Iterator<Song> songIterator = playlist.iterator();
        while (songIterator.hasNext()) {
            System.out.println("Playing: " + songIterator.next().getTitle());
        }

        // LinkedList Iterator
        System.out.println("\n--- LinkedList Iterator ---");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Node 1");
        linkedList.add("Node 2");
        linkedList.add("Node 3");

        Iterator<String> listIterator = linkedList.iterator();
        while (listIterator.hasNext()) {
            System.out.println("Visited: " + listIterator.next());
        }

        // Binary Tree Iterator
        System.out.println("\n--- BinaryTree Iterator (In-order) ---");
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);

        Iterator<Integer> treeIterator = tree.iterator();
        while (treeIterator.hasNext()) {
            System.out.println("Visited: " + treeIterator.next());
        }
    }
}
