class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node , long dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];
        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a.dist, b.dist)
            );

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0,0));
        long MOD = 1_000_000_007;
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int u = current.node;
            long currentDist = current.dist;
            if(currentDist > dist[u]) continue;
            for(Pair edge: graph.get(u)){

                int v = edge.node;
                long newDist = currentDist +edge.dist;

                if(newDist<dist[v]){
                    dist[v]= newDist;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v,newDist));
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n-1];
    }
}

//  shortest
//  no. of ways
//  dijkstra