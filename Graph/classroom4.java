import java.util.*;
public class classroom4 {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
 
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]){
        for(int i=0; i<graph.length;i++){
            int v =i;
            for(int j =0; j < graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length]; // array till graph vertex could be 0 1 2 3 4 5 ...so on and les also 0 1 2
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        // Add element whose indegree is equal to 0
        for(int i=0; i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i); // adding those element with 0 values in our array
            }
        }

        // Now remove
        // Concept is Here we use Queue will only those with indeg == 0 an 
        while(!q.isEmpty()){
            int curr = q.remove(); // remove 0 value element  
            System.out.print(curr+" ");
            // Now check for neighbor and decrease their indegree
            for(int i=0; i<graph[curr].size();i++){
                Edge e = graph[curr].get(i); // 
                indeg[e.dest]--;
                if(indeg[e.dest] ==0){
                    q.add(e.dest);
                }
            }

        }

        /* 
        // bellman ford 
        public static void bellmanFord(ArrayList<Edge> graph[], int src){
            int [] dist = new int[graph.length];
            for(int i=0; i<dist.length; i++){
                if(i!= src){
                    dist[i] = Integer.MAX_VALUE;
                }
            }
            int V = graph.length;
            // algo 
            for(int i=0; i < V-1; i++){ // for every vertex 
                //edges
                for(int j=0; j<graph.length;j++){ // for every edge 
                    for(int k=0; k < graph[j].length;k++){
                        Edge e = graph[j].get(k);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        // relaxation- we are finding the shortest path 
                        if(dist[u] != Integer.MAX_VALUE && dist[u]+ wt < dist[v]){
                            dist[v] = dist[u] + wt;
                        }
                    }
                }
            }
            for(int i=0; i <dist.length; i++){
                System.out.println(dist[i]+" ");
            }
            System.out.println();

        }
       */

    }
    public static void main(String[]args){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);

    }
}
