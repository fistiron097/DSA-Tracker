//                           Cheap flights within K stops s

/*
import java.util.*;
public class questions {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(int flights [][],ArrayList<Edge> graph[]){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int v;
        int cost;
        int stop;

        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights,graph);

        int [] dist = new int[n];
        for(int i=0; i<n; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stop > k){
                break;
            }

            for(int i=0; i<graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+ wt < dist[v] && curr.stop <= k){
                    dist[v] = dist[u]+wt;
                    q.add(new Info(v, dist[v], curr.stop+1));
                }

                
                // if(curr.cost+ wt < dist[v] && curr.stop <= k){
                //     dist[v] = curr.cost+wt;
                //     q.add(new Info(v, dist[v], curr.stop+1));
                // }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        } else{
            return dist[dest];
        }
    }
    public static void main(String[]args){
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst= 3, k =1;
        System.out.println(cheapestFlight(n, flights, src, dst, k));
    }
}
 */

/* 
import java.util.*;

public class questions{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(int [][] cities, ArrayList<Edge> graph[] ){
        int V = cities.length;
        // Intialization
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // now storing the graph
        for (int i = 0; i < V; i++) { // i represents src
            for (int j = 0; j < V; j++) { // j represents dest
                if (cities[i][j] != 0) { // 0 means no edge
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
      
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }
        @Override
            public int compareTo(Pair p2){
                return this.cost - p2.cost; // ascending Order  
            }
    }


    public static void prims(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length]; // for not coming back to node that we visited that's why created 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost =0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost+= curr.cost;
 
                for(int i=0; i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }

            }
        }
        System.out.println("Final cost of MST:- " + finalCost);
    }

    public static void main(String[]args){
        int [][] cities = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0},
        };
        int V = cities.length;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(cities, graph);
        prims(graph);
    }   
}
*/

// Mother Vertex
// We have a Directed Graph, find a Mother Vertex in the Graph (if present). A Mother Vertex is a
// vertex through which we can reach all the other vertices of the Graph.

// import java.util.*;
// public class questions{
//     static class Edge{
//         int src;
//         int dest;
//         int wt;

//         public Edge(int s, int d, int w){
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }
//     public static void createGraph(ArrayList<Edge>[] graph){
//         for(int i=0; i < graph.length; i++){
//             graph[i] = new ArrayList<>();
//         }
//         graph[0].add(new Edge(0, 1, 0));
//         graph[1].add(new Edge(1, 2, 0));
//         graph[2].add(new Edge(0, 0, 0));
//         graph[3].add(new Edge(3, 4, 0));
//         graph[4].add(new Edge(0, 0, 0));
//     }

//     public static void dfs(ArrayList<Edge>[] graph , boolean[]vis){
//         for(int i = 0; i < graph.length;i++){
//             if(!vis[i]){
//                 dfsUtil(graph, vis, i);
//                 // jab saare visited ho jaye to check kr lo ki array saara visited hai nahi 
//                 // backtracking step
                    
//             }
//         }
//     }

//     public static void dfsUtil(ArrayList<Edge>[] graph , boolean[]vis, int curr){
//         vis[curr] = true; // mark krna hai taki non repeat ho 
//         for(int i=0; i < graph[curr].size(); i++){
//             Edge e = graph[curr].get(i);
//             if(!vis[e.dest]){
//                 dfsUtil(graph, vis, e.dest);
//             }
//         }   
//     }


//     public static void main(String[]args){
//         int V = 5;
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         boolean vis[] = new boolean[V];
//         createGraph(graph);
//     }
// }

// Q2 -      Implement Union Find Algo for Undirected graph
import java.util.*;

public class questions {
    static int n = 10;  // Increased to accommodate large indices in edges
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);  // Since it's an undirected graph
    }

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);  // Path Compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;  // Already connected, no need to merge

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        init();  // Initialize parent and rank arrays

        for (int u = 0; u < adj.size(); u++) {
            for (int v : adj.get(u)) {
                if (u < v) {  // Avoid checking edges twice in undirected graph - if we are visiting 0-1 then 1-0 we do not have to 
                    int parentU = find(u);
                    int parentV = find(v);

                    if (parentU == parentV) {
                        return true;  // Cycle detected
                    }

                    union(u, v);
                }
            }
        }
        return false;  // No cycle found
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(9, 1, adj);
        addEdge(9, 5, adj);
        addEdge(1, 5, adj);
        addEdge(1, 9, adj);
        addEdge(5, 2, adj);
        addEdge(5, 9, adj);
        addEdge(5, 1, adj);
        addEdge(2, 7, adj);
        addEdge(2, 5, adj);
        addEdge(7, 2, adj);

        if (isCycle(adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
