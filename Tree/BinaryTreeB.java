//                                       Pre-Order Tree 
import java.util.*;
public class BinaryTreeB{
    static class Node{
        int data;
        Node left;
        Node right;
        //Constructor 
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1; // same var used by other obj
        public static Node buildTree(int nodes[]){ // static class ke andar static function define kiya 
            idx++; // idx moves from -1 to 0 idx = 0
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                System.out.println("-1");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data);
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelorder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }

        }
        public static int count(Node root){
            if(root ==null){
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount+rightCount+1;
        }

        public static int sum(Node root){
            // edge case
            if(root == null){
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            int treeSum = left+right+(root.data);

            return treeSum;
        }

        public static int height(Node root){
            // edge case 
            if(root == null){
                return 0;
            }
            int leftHt = height(root.left);
            int rightHt = height(root.right);
            return Math.max(leftHt,rightHt) + 1;
        }

        public static int diameter2(Node root){ // O(N^2)
            if(root == null){
                return 0;
            }
            int leftDiam = diameter2(root.left);
            int leftHt = height(root.left);
            int rightDiam = diameter2(root.right);
            int rightHt = height(root.right);

            int selfDiam = leftHt+rightHt+1;

            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }

        static class Info{
            int diam;
            int ht;
            //Constructor call 
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }


        public static Info diameter(Node root){ 
           // edge case
           if(root == null){
            return new Info(0,0);
           }
           Info leftInfo = diameter(root.left);
           Info rightInfo = diameter(root.right);

           int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
           int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;

           return new Info(diam,ht);
        }

        public static boolean isIdentical(Node node, Node subRoot){
            if(node == null && subRoot == null){
                return true;
            } else if(node == null || subRoot == null || node.data != subRoot.data){
                return false;
            }
            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }
            return true;
        }
        
        public static boolean isSubtree(Node root,Node subRoot){
            if(root == null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }
        
        public static void kthLevel(Node root, int level,int k){
            if(root == null){
                return;
            }
            if(level ==k){
                System.out.print(root.data);
                return;
            }
            kthLevel(root.left, level+1, k);
            kthLevel(root.right, level+1, k);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
            
            if(foundLeft || foundRight){
                return true;
            }
    
            path.remove(path.size()-1);
            return false;
        }

        public static Node lca(Node root,int n1, int n2){
            // path find krna 
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
    
            getPath(root,n1,path1);
            getPath(root,n2,path2);
            // lowest common ancestor 
            int i = 0;

            for(; i<path1.size() && i < path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca = path1.get(i-1);
            return lca;
        }

        //         Optimized Approach
        public static Node lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data ==n2){
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            // leftLca = val rightLca = null
            if(rightLca ==null){
                return leftLca;
            }
            if(leftLca == null){
                return rightLca;
            }
            return root;
        }

        public static int lcaDist(Node root, int n){
            if(root ==null){
                return -1;
            }
            if(root.data ==n){
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            } else if(leftDist == -1){
                return rightDist+1;
            } else{
                return leftDist+1;
            }
        }

        public static int minDist(Node root, int n1,int n2){
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca,n1);
            int dist2 = lcaDist(lca, n2);

            return dist1+dist2;
        }

        public static int kthAncestor(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
               return 0 ;
            }
            int lft = kthAncestor(root.left,n,k);
            int right =kthAncestor(root.right,n,k);

            if(lft == -1 & right == -1){
                return -1;
            }
            int max = Math.max(lft, right);
            if(max+1 == k){
                System.out.println(root.data);
            }
            return max+1;

        }
    }
     
    public static void main(String[]args){
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();// we create object of class BinaryTree
        // Node root = tree.buildTree(nodes);
        //tree.levelorder (root);
        /*
               1
              / \
             2   3
            / \  /\
           4  5  6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        int n1 = 4; 
        int n2 = 2;
        int k = 2;
        //System.out.print(BinaryTree.kthAncestor(root, n2, k));
        BinaryTree tree = new BinaryTree();
        System.out.println(root.left.data);
   }
}