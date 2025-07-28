
//                           Queue using 2 stack

/* 
import java.util.*;

public class Question {

    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty(); // No need to check for stack 2 beacuse it's for temporary use 
        }
    
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
    
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    
        public static int remove(){
            if(isEmpty()){
                System.out.print("Queue us empty");
                return -1;
    
            }
            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.print("Queue us empty");
                return -1;
    
            }
            return s1.peek();
        }

    
    }

    

    public static void main(String[]args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }   
}
*/


//                                    Stack using 2 queue

/*
import java.util.*;

public class Question{
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();


        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    
        public static void push(int data) {
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }
    
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return -1;
            }
            int top = -1;

            // case1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;

        }

        //                                
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Stack");
                return -1;
            }
            int top = -1;

            // case1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;

        }
    
    }


    public static void main(String[]args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}

 */


//                                                     Non-repeating characters in a string 


/* 
import java.util.*;

public class Question{
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        // Loop for traversing the string 
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }

            System.out.println();
        }
    }
    public static void main(String[]args){
        String str = "aabccxb";
        printNonRepeating(str);

    }
}

*/
//                                             Interleave 2 halves of a Queue(even length)

/* 
import java.util.*;

public class Question{

    public static void interleaveTwohalves(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i = 0;i < size/2 ; i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

    }
    public static void main(String[]args){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleaveTwohalves(q);

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");

        }

    }
}
*/

/*                              Generate Binary Number
class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(N-- > 0 ){
            String temp = q.remove();
            ans.add(temp);
            q.add(temp +"0");
            q.add(temp +"1");
        }
        return ans;
    }
    
}
*/

//                                     Reversal of queue
/* 
import java.util.*;

public class Question{
    public static void reversalQueue(Queue<Integer>q){
      Stack<Integer> s = new Stack<>();
      while(!q.isEmpty()){
        s.push(q.remove());
      }
      while(!s.isEmpty()){
        q.add(s.pop());
      }
    }
    public static void main(String[]args){
      Queue<Integer> q = new LinkedList<>();
      for(int i = 1; i <= 5; i++){
        System.out.println(q.add(i));
      }
      reversalQueue(q);
      // print queue
     while(!q.isEmpty()){
        System.out.print(q.remove()+"");
     }
     System.out.println();
    }
}
*/

