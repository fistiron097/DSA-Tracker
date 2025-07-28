public class linkedlistQueue{

    static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
    static Node head = null;
    static Node tail = null;

   public static boolean isEmpty(){
     return head == null && tail == null;
 }
 
 
 public void add(int data){
    Node newNode = new Node(data);

    if(head == null){
        head = tail = newNode;
    }
    tail.next = newNode;
    tail = newNode;
 }
 
 public static int remove(){
     if(isEmpty()){
        System.out.print("Queue is empty");
        return -1;
     }
     int front = head.data;
     // single element
     if(head == tail){
        head = tail = null;
     }
     else{
        head = head.next;
     }
     return front;
 
 }
 
 // Peek element --- Top element ko peak krna hai 
 
 public static int peek(){
    if(isEmpty()){
        System.out.print("Empty queue");
        return -1;
    }
      return head.data;
 }
 
 
 }

public static void main(String[]args){
    Queue q = new Queue(3);
    q.add(1);
    q.add(2);
    q.add(3);
    System.out.println(q.remove());
    q.add(4);
    System.out.println(q.remove());
    q.add(5);

    while(!q.isEmpty()){
        System.out.print(q.peek());
        q.remove();
    }

 }

}