public class circularQueueB{

    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;   

        // constructor based queue
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Operation on queue

       // Stack is empty or not 

   public static boolean isEmpty(){
     return rear == -1 && front == -1;
 }
 
 // isFull 
 public static boolean isFull(){
    return (rear+1)% size == front;
 }
 // Adding ---- 0(1)
 
 public void add(int data){
    // base condition for full array
     if(isFull()){
         System.out.println("queue is full");
         return;
     }

     if(front == -1){
        front=0;
     }

     rear = (rear+1)% size;
     arr[rear] = data;
  }
 
 // Removing ----- in array takes 0(n)
 
 public static int remove(){
     // base condition
     if(isEmpty()) {
         System.out.println("empty queue");
         return -1;
     }
 
     int result = arr[front];
     // if we are removing last element 
     if( rear == front){
        rear = front = -1;
     }
     else{
        front = (front+1)%size;
     }
     return result;
 
 }
 
 // Peek element --- Top element ko peak krna hai 
 
 public static int peek(){
     if(isEmpty()) {
         System.out.println("empty queue");
         return -1;
     }
     return arr[front];
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