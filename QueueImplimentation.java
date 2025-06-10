public class QueueImplimentation {
    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    static class queueImplimentation{
        private Node front=null;
        private Node rear=null;

        public queueImplimentation(){
            this.front = this.rear = null;
        }
        public void enquue(int value){
            Node newNode = new Node(value);
            if(rear == null){
                front = rear = newNode;
                return;
            }
            rear.next=newNode;
            rear= newNode;
        }
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int value = front.data;
            front=front.next;
            if(front==null){
                rear=null;
                return value;
            }
            return value;
        }
        
    }
}
