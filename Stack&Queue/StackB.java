//                                    Implementation of Stack using ArrayList
/* 
import java.util.ArrayList;
public class Stack {
    // Intialize Arraylist
    static ArrayList<Integer> list = new ArrayList<>();
    // isEmpty()
    public static boolean isEmpty(){
        return list.size() ==0;
    }

    // push operation
    public static void push(int data){
       list.add(data);
    }

    // pop operation 
    // why we are not passing the value.Here we just want to delete top element and store it so that i get transfered to default stack
    public static int pop(){
        // corner case 
        if(isEmpty()){
            return -1;
        }
        int top = list.get(list.size()-1);
        list.remove(list.size() - 1);
        return top;
    }
    // peek operation

    public static int peek(){
        // corner case 
        if(isEmpty()){
            return -1;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[]args){
        Stack s = new Stack(); // object banaya hai stack class ke 
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


//                              Implementation of Stack using Linked List

/* 
import java.util.*;
public class StackB {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.next = next;
            this.next = null;
        }
        static class Stack{
            static Node head = null;

            public static boolean isEmpty(){
                return head == null;
            }

//           Push Operation 
            public static void push(int data){
                Node newNode= new Node(data);
                if(isEmpty()){
                    head = newNode;
                }
                newNode.next = head;
                head = newNode;
            }
//             Pop function 
           public static int pop(){
            if(isEmpty()){
                return -1;
            }
             int top= head.data;
             head = head.next;
             return top;

           }
           public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
           }


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

//----------------------------------------  Question --------------------------------------------------------------------

// import java.util.*;

// public class StackB{

//     public static void PushBottom(Stack<Integer>s, int data){
//         if(s.isEmpty()){
//             s.push(data);
//             return;
//         }

//         int top = s.pop();
//         PushBottom(s,data);// here this s will get updated in every recusrive calls 
//         s.push(top);

//     }       

//     public static String reverseString(String str){
//         Stack<Character> s = new Stack<>();
//         for(int i = 0 ;i < str.length(); i++){
//             s.push(str.charAt(i));
//         }

//         StringBuilder result = new StringBuilder("");
//         while(!s.isEmpty()){
//             char curr = s.pop();
//             result.append(curr);
//         }

//         str = result.toString();
//         return str;

//     }

//     public static void reverseStack(Stack<Integer>s){
//         if(!s.isEmpty()){
//             return; // If a stack is empty then it's reverse is also empty
//         }
//         int top = s.pop();
//         reverseStack(s); // updated stack will be passed 
//         PushBottom(s, top);
//     }

//     public static void printStack(Stack<Integer> s){
//         while(!s.isEmpty()){
//             System.out.println(s.pop());
//         }
//     }

//     public static void stockSpan(int stocks[] , int span[]){
//         Stack<Integer> s = new Stack<>();
//         span[0] = 1;
//         s.push(0);

//         for(int i = 1 ; i < stocks.length; i++){
//             int currPrice = stocks[i];
//             while(!s.isEmpty() && stocks[s.peek()] < currPrice){
//                 s.pop();
//             }
//             if(!s.isEmpty()){
//                 span[i] = i+1;
//             }
//             else{
//                 int prevHigh = s.peek(); // calculating the array element value at each index 
//                 span[i] = i - prevHigh;
//             }
//             s.push(i); // Push the index into stack 
//         }
//     }
//     public static void main(String[]args){
//         /* 
//         Stack<Integer> s = new Stack<>();
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         PushBottom(s, 4);

//         while(!s.isEmpty()){
//             System.out.println(s.pop());
//         }
//         */
//         int [] stocks = {100, 80 , 60 , 70 , 60 , 85 , 100};
//         int [] span = new int[stocks.length];
//         stockSpan(stocks,span);

//         for(int i= 0; i < span.length ; i++){
//             System.out.print(span[i]+" ");

//         }

//     }
// }

//---------------------------------------- Q- Next Greater Element --------------------------- 
//-------------------------------------------Brute Force approach ---------------------------------------------------------
/* 
public class StackB{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        long[] ans = new long[arr.length];
        ans[n-1] = -1;
        for(int i = 0; i < n-1;i++){
            for(int j = i+1; j < n;j++){
                if(arr[i] < arr[j]){
                    ans[i] = arr[j];
                    break;
                }
                else{
                    ans[i] = -1;
                }
            }
        }
        return ans;
    } 
    public static void main(String[]args){
        long [] arr = {1,3,2,4};
        int n = arr.length;
        System.out.println(nextLargerElement(arr, n));
    }

}
*/

//----------------------------------------------Optimal soltuion---------------------------------------------------

/* 
import java.util.*;
public class StackB{
    public static void main(String[]args){
        int [] arr = {2,4,0,9,6};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length]; // next Greater elemet store hoga ismei

        for(int i = arr.length-1 ; i>= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i = 0; i< nxtGreater.length; i++){
            System.out.print(nxtGreater[i]+ " ");
        }
        System.out.println();
    }
}

*/



//                           Brute-Force Approach 


/*
import java.util.*;

public class StackB{
    public static int[] GreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE; // Reset max for each iteration
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            result[i] = (max != Integer.MIN_VALUE && arr[i] < max) ? max : -1;
        }
        
        return result;
    }

    public static void main(String args[]) {
        int[] arr = {2,4,0,9,6};
        int[] result = GreaterElement(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
*/

/* 
--------------------------Q1- Place x element in the bottom of Stack----------------------------------------------------
--------------------------- 2 approaches 1- Meri waali 2- By using recursion we can also achieve------------------------
import java.util.*;
public class StackB{
    public static void main(String[]args){
        ArrayList<Integer> a1 = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        int x = 2;
        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1);
        s1.push(8);
        while(!s1.isEmpty()){
            a1.add(s1.pop());
        }
        s1.push(x);
        for(int i= a1.size()-1; i>=0; i--){
            s1.push(a1.get(i));
        }
        System.out.println(s1);
    }
}

*/
/* 
import java.util.*;
public class StackB{
    public static void reverseStack(Stack <Integer> s){
        // base case 
        if(s.isEmpty()){
            return;
        }

        //recursion 
        int top = s.pop();
        reverseStack(s);
        s.push(top);

    }
    public static void main(String[]args){
       Stack<Integer> s = new Stack<>();
       s.push(3);
       s.push(2);
       s.push(1);
       s.push(7);
       s.push(6);
       reverseStack(s);
    }
}
*/
/* 
//---------------------------------------Takda Question hai yeh ----------------------------------------------------------------
import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        int pos = 0; // Track position to place non-zero elements

        // Traverse the array and perform merging and shifting in a single pass
        for (int i = 0; i < n; i++) {
            // If the current element and the next one are the same and non-zero, merge them
            if (i < n - 1 && arr[i] == arr[i + 1] && arr[i] != 0) {
                arr[i] *= 2;
                arr[i + 1] = 0; // Set the next element to 0 after merging
            }

            // If the current element is non-zero, move it to the correct position
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        // Fill the remaining positions with 0
        while (pos < n) {
            arr[pos++] = 0;
        }

        // Convert the array to an ArrayList and return
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            ans.add(x);
        }

        return ans;
    }
}
*/
//--------------------------------------------Duplicate Parentheses -------------------------------------------------------------
/* 
import java.util.*;
public class StackB{
    static boolean isDuplicate(String str) {
        // Stack create kro 
        Stack<Character> s = new Stack<>();

        for(int i =0; i< str.length();i++){
            char curr = str.charAt(i);
            //closing
            if(curr==')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
            } else{
                s.push(curr);
            }
        }
        return false;
    }
    public static void main(String[]args){
        String str = "(a+b)"; 
        System.out.println(isDuplicate(str));
    }
}

*/

import java.util.*;
public class StackB{
    public static void main(String[]args){
        int [][] matrix = {
            {1,2,3},
            {4,5,6},
        };
        ArrayList<ArrayList<Integer>> multiDim = new ArrayList<>(); // Created multi-dimensional array
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<m; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = n-1; j>=0; j--){
                row.add(matrix[j][i]);
            }
            multiDim.add(row);
        }
        System.out.print(multiDim);


    }

}
