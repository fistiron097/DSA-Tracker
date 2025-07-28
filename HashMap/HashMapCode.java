import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{ // <K,V> generic we used it for any type variable
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int N;
        private int n;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked") //  

        public HashMap(){
            this.N =4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
           int hc = key.hashCode(); // it will integer value but random value could be anything
           return Math.abs(hc) % N; // return kar diya 
        }

        private int SearchInLL(K key, int bi){ //  we are passing the key we want to search at that bi index.
          LinkedList<Node> ll = buckets[bi];
          int di =0;
          //looping
          for(int i=0; i< ll.size();i++){
            Node node = ll.get(i);
            if(node.key.equals(key)){
                return di;
            }
            di++;
          }
           return -1;
        }

        @SuppressWarnings("unchecked")

        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets; // we store our buckets data in oldBucket
            buckets = new LinkedList[2*N];
            N = N*2;
            // lets set empty linked list in this new bucket array
            for(int i=0; i < buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            // remove node from old bucket to new bucket and add node in new Bucket
            for(int i=0; i< oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j =0; j<ll.size();j++){
                    Node node = ll.get(i);
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key, V value){// 0(lambda) - 0(1) 
            int bi = hashFunction(key); // return ho ke aya array ka index where we will trverse our linked list 
            int di = SearchInLL(key,bi);// after getting index we are traversing the linked list 
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lamba = (double) n/N;
            if(lamba > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key); // return ho ke aya array ka index where we will trverse our linked list 
            int di = SearchInLL(key,bi);// after getting index we are traversing the linked list 
            if(di != -1){
                return true;
            }else{
               return false;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key); // return ho ke aya array ka index where we will trverse our linked list 
            int di = SearchInLL(key,bi);// after getting index we are traversing the linked list 
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public V get(K key){
            int bi = hashFunction(key); // return ho ke aya array ka index where we will trverse our linked list 
            int di = SearchInLL(key,bi);// after getting index we are traversing the linked list 
            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }
    public static void main(String[]args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China",50);
        hm.put("US", 150);

        ArrayList<String> keys = hm.keySet();
        for (String key: keys){
            System.out.println(key);
        }
    }
}
