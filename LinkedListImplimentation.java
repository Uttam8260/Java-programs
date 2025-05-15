public class LinkedListImplimentation {

    public static class Node {
        Node next;
        Object ele;

        Node(Object ele) {
            this.ele = ele;
        }
    }

    public static class LinkedList {
        private Node first = null;
        private int count = 0;

        public void add(Object ele) {
            if (first == null) {
                first = new Node(ele);
            } else {
                Node curr = first;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new Node(ele);
            }
            count++;
        }

        public void add(int index, Object ele) {
            if (index < 0 || index > count) {
                throw new IndexOutOfBoundsException();
            }
            Node curr1 = new Node(ele);
            if (index == 0) {
                curr1.next = first;
                first = curr1;
            } else {
                Node curr = first;
                for (int i = 1; i < index; i++) {
                    curr = curr.next;
                }
                curr1.next = curr.next;
                curr.next = curr1;
            }
            count++;
        }

        public void remove() {
            if (count == 0) {
                System.out.println("No node to be removed");
                return;
            }
            if (count == 1) {
                first = null;
            } else {
                Node curr = first;
                while (curr.next.next != null) {
                    curr = curr.next;
                }
                curr.next = null;
            }
            count--;
        }

        public void remove(int index) {
            if (index < 0 || index >= count) {
                throw new IndexOutOfBoundsException();
            }
            if (index == 0) {
                first = first.next;
            } else {
                Node curr = first;
                for (int i = 1; i < index; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
            count--;
        }

        public int size() {
            return count;
        }

        public void display() {
            Node curr = first;
            while (curr != null) {
                System.out.println(curr.ele);
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(21);
        l.display();
        System.out.println("After adding 60 and removing index 1:");
        l.add(60);
        l.remove(1);
        l.display();
    }
}
