import java.util.*;
public class practise{
    static class Node{
        int data;
        Node left;
        Node right;
       public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void main(String[]args){
        int [] val = {1,2,3,4,6}; // array 
        for(int i = 0; i< val.length;i++){
            Node root = new Node(val[i]);
        }
        
    }
}