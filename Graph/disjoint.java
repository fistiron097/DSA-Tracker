import java.util.*;
public class disjoint {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0; i<par.length; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x]=find(par[x]); // this step is path compression // we are cutting extra recursion 
    }
    public static void union(int a, int b){
            int parA = find(a);
            int parB = find(b);

            if(rank[parB] == rank[parA]){
                par[parB] = parA;
                rank[parA]++;
            } else if(rank[parA] < rank[parB]){
                par[parA] = parB;
            } else{
                par[parB] = parA;
            }

    }
    public static void main(String[]args){     
        init();
        union(1, 3);    
    }
}
