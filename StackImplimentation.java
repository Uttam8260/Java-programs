
public class StackImplimentation {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        } 
    }
    static class stackImplimentaton{
        Node top=null;
        public void push(int data){
            Node newNode =new Node(data);
            newNode.next=top;
            top=newNode;
        }
        public void pop(){
            if(top==null){
                System.out.println("Stack is empty");
            }
            else{
                top=top.next;
            System.out.println("Element is popped");
            }
        }
        public void peek(){
            if(top==null){
                System.out.println("stack is empty");
            }
            else {
                System.out.println(top.data);
            }
        }
        public boolean isEmpty(){
            return top==null;
        }
        public void display(){
            if(top == null){
                System.out.println("Stack is empty");
            }
            else{
                Node current=top;
                while(current !=null){
                    System.out.println(current.data);
                    current=current.next;
                }
            }
        }
        
    }
    public static void main(String[] args) {
            stackImplimentaton s=new stackImplimentaton();
            s.push(10);
            s.push(32);
            s.push(31);
            s.display();
            s.pop();
            System.out.println("After popping element");
            s.display();
            System.out.println("Is stack empty:-"+s.isEmpty());
           s.peek();
        }
}
