import java.util.*;
public class classroom2{
    static class Edge{ // is class ka object creation karenge 
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length;i++){ // graph.length we mean how many V we have 
            graph[i] = new ArrayList<>();// is seh pehle pr array value is null and after this step our arraylist is initialized as null
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(6, 5));

    }
    // Detect cycle in an undirected graph  
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] =  new boolean[graph.length];
        for(int i=0; i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr] = true;

        for(int i=0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case 3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            //case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i=0; i<col.length;i++){
            col[i] = -1;
        }
        // yaha seh we have assigned -1 to each value in our array
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length;i++){
            if(col[i] == -1){
                q.add(i); // 0
                col[i] = 0; // assign yellow colour
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; i < graph[curr].size(); i++){
                        Edge e = graph[curr].get(j); // e.dest
                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0  ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]){
                            return false;
                        }

                    }

                }
            }

        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge>[]graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i < graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[]graph, int curr , boolean vis[] , boolean[]stack){
        vis[curr] = true;
        stack[curr] = true;

        for(int i= 0; i < graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            // If in our stack our current element is there
            if(stack[e.dest]){
                return true;
            }
            if(!vis[curr] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false; // backtracking step hai na 
        return false;

    }


    public static void main(String[] args){
       int V = 7;
       ArrayList<Edge> graph[] = new ArrayList[V];
       createGraph(graph);
       //bfs(graph);
     
    }
}