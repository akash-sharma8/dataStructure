class Solution {
    public class Pair {
        int node;
        double p;
        public Pair(int node,double p){
            this.node = node;
            this.p = p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] sp, int s, int e) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n ; i++) adj.add(new ArrayList<>());

        for(int i =0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double w = sp[i];
            adj.get(a).add(new Pair(b, w));
            adj.get(b).add(new Pair(a, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.p, a.p));
        pq.offer(new Pair(s, 1.0));
        double[] pa = new double[n];
        pa[s]=1.0;
        while(!pq.isEmpty()){
            Pair front = pq.remove();
            int node = front.node;
            double d = front.p;
            if(d<pa[node]) continue;
            if(node==e) return d;
            for(Pair pair: adj.get(node)){
                if(pair.p * d > pa[pair.node]){
                    pa[pair.node] = pair.p * d;
                    pq.add(new Pair(pair.node, pair.p * d));
                }
            }
        }

    return 0;
    }
}