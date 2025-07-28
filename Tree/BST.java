import java.util.ArrayList;
import javax.swing.tree.TreeNode;

public class BST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }

    }

    //        Important one 
    // Size of largest BST in Binary Tree

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;


    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size +rightInfo.size +1;
        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false,size,min,max);
        }
        // for root if it is BST
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);
    }
    // Insert Operation in BST

    public static Node insert(Node root, int val){
        if(root == null){
            // create krenge node
            root = new Node(val); // we can create Node obj = new Node(val) and then assign root = obj, but we directly assign it to root
            return root;
        }
        // comparison
        if(root.data > val){
            // right subtree
            root.left = insert(root.left, val);
        }else{
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    // Search Operation IN BST 
    public static boolean search(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }

        if(val < root.data){
            return search(root.left, val);
        }else{
            return search(root.right, val);
        }

    }

    public static Node inorderSuccessor(Node root,int val){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int val){
        if(val < root.data){
            root.left = delete(root.left, val);
        } 
        else if(val > root.data){
            root.right = delete(root.right, val);
        }
        else{
            // This is the condition where we found our key to delete val to delete
            // case1
            if(root.left == null && root.right == null){
                return null;
            }
            // case2
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //case 3
            Node IS =inorderSuccessor(root.right,val); // 6
            root.data = IS.data; // 5 ko 6 seh replace 
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    
    // Sorted Array ko Binary Search Tree mei convert krna
    public Node sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    public static Node constructBST(int[] nums, int left, int right) {
        if (left > right) return null; // Base case
        int mid = left + (right - left) / 2; // Middle element for balance
        Node root = new Node(nums[mid]);
        root.left = constructBST(nums, left, mid - 1); // Build left subtree
        root.right = constructBST(nums, mid + 1, right); // Build right subtree
        return root;
    }

     public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // IS Valid BST
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null) return true;
        
        // for rightsubtree- root should be not greater than nodes 
        if(min !=null && root.data <= min.data){
            return false;
        }
        // for left subtree- 
        else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right, root, max);
    }

    // Print keys in range - for BST 
    private static void inorder(Node root, ArrayList<Integer>res, int i, int j){
        if(root == null){
            return;
        }
        inorder(root.left,res,i,j);
        if(root.data >= i && root.data <= j) res.add(root.data);
        inorder(root.right,res,i,j);
    }

    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root,res,low,high);
        return res;
        
    }

    // Root to leaf path

    public static void printPath(ArrayList<String> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
    }
    public static void printRoot2Leaf(Node root, ArrayList<String> path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            printPath(path);
        }
        path.add(String.valueOf(root.data));
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    // Convert BST to balanced Binary Search Tree
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st > end) return null;
        int mid = st +(end-st)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder,mid+1,end); 
        return root;
    }

    public static Node balanceBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder); // this function gives sorted inorder seq

        // sorted inorder-> balanced BST
        root = createBST(inorder,0,inorder.size()-1);
        return root;
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }

    public static Node createBST(ArrayList<Integer>arr,int st, int end){
        if(st  > end){
            return null;
        }
        int mid = (st+end) /2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;

    }
    public static Node mregeBSTs(Node root1,Node root2){
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);
        //step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);

        // merge
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            } else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
        }
        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
        }

        // sorted AL -> balanced BST
        return createBST(finalArr,0,finalArr.size()-1);
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[]args){
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null; // initial node creation kiya 
        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        root = delete(root, 5);
        System.out.println();

        inorder(root);

        // if(search(root,1)){
        //     System.out.print("FOUND");
        // }else{
        //     System.out.println("NOT FOUND");
        // }
        Node root = mregeBSTs(root1, root2);
        preorder(root);

    }

}

