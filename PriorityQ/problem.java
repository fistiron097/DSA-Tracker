import java.util.PriorityQueue;

public class problem {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;
        }
    }
    public static void main(String[]args){
        /*
        int pts[][] = {{3,3},{5,-1},{-2,4}}; // co ordinates are stored in 2d array 
        int k = 2;
        // Create Priority Queue
        PriorityQueue<Point> pq = new PriorityQueue<>();
        // we store co-ordinates
        for(int i =0; i < pts.length ; i++){
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0] , pts[i][1], distSq,i));
        }
        // find the nearest k value
        for(int i =0 ; i < k;i++){
            System.out.println("C"+pq.remove().idx);
        }
        */

        /* 
        int [] ropes = {2,3,3,4,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min+min2;
            pq.add(min+min2);
        }
        System.out.println("Minimum Cost is :- "+cost);
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [][] cell = {
            {31,100,65,12,18},
            {10,13,47,157,6},
            {100,113,174,11,33},
            {88,124,41,20,140},
            {99,32,111,41,20}
        };
        int row = cell.length;
        int col = cell[0].length;
        int top_left = cell[0][0];
        int bottom_right = cell[row-1][col-1];

        pq.add(top_left);
        
        for(int i=0; i < cell.length; i++){
            for(int j = 0; j < cell[0].length;j++){
                //up
                int up = cell[i-1][j];
                //bottom
                int bottom = cell[i+1][j];
                //left
                int left = cell[i][j-1];
                //right
                int right = cell[i][j+1];

                int min1 = Math.min(up,bottom);
                int min2 = Math.min(left,right);
                int min3 = Math.min(min1,min2);
                if(top_left < min3){
                    top_left = min3;
                    pq.add(min3);
                }

            }
        }

    }
}
