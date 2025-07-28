import java.util.LinkedList;
import java.util.*;

public class QueueB{

    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        // constructor based queue
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        

        // Operation on queue

       // Stack is empty or not 

   public static boolean isEmpty(){
     return rear == -1;
 }
 
 // Adding ---- 0(1)
 
 public void add(int data){
    // base condition for full array
     if(rear == size-1){
         System.out.println("queue is full");
         return;
     }
     rear = rear + 1;
     arr[rear] = data;
 
 }
 
 // Removing ----- in array takes 0(n)
 
 public static int remove(){
     // base condition
     if(isEmpty()) {
         System.out.println("empty queue");
         return -1;
     }
 
     int front = arr[0];
     for(int i= 0; i< rear; i++){
         arr[i] = arr[i+1];
     }
     rear = rear - 1;
     return front;
 
 }
 
 // Peek element --- Top element ko peak krna hai 
 
 public static int peek(){
     if(isEmpty()) {
         System.out.println("empty queue");
         return -1;
     }
     return arr[0];
 }


 }

public static void main(String[]args){
    Queue q = new Queue(5);
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);

    // while(!q.isEmpty()){
    //     System.out.print("Original queue is "+ q.peek());
    //     q.remove();
    // }

 }

}