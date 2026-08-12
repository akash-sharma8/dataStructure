class Solution {
    public class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int dist;
        public Triplet(int node , int parent , int dist){
            this.node = node;
            this.parent = parent ;
            this.dist = dist;
        }

        public int compareTo(Triplet t){
            if(this.dist == t.dist) return Integer.compare(this.node, t.node);
            return this.dist- t.dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        int sum =0;
        boolean[] vis = new boolean[n];
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            int node = top.node;
            int parent = top.parent;
            int dist = top.dist;
            if(vis[node]==true) continue;
            sum+=dist;
            vis[node] = true;
            for(int i =0; i<n; i++){
                if(i==node || i==parent) continue;
                if(vis[i]==true) continue;
                int x1= points[node][0], y1= points[node][1];
                int x2= points[i][0], y2= points[i][1];
                int mDis = Math.abs(x2-x1)+ Math.abs(y2-y1);
                pq.add(new Triplet(i, node,mDis));
            }

        }
    return sum;
    }
}