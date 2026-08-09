class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p){
            if(this.time==p.time) return this.node-p.node;
            return this.time-p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0 ; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i<times.length; i++){
            int a = times[i][0];
            int b = times[i][1];
            int w = times[i][2];
            adj.get(a).add(new Pair(b,w));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair front = pq.remove();
            int node = front.node, time = front.time;
            for(Pair p: adj.get(node)){
                if(time>ans[node]) continue;
                if(p.time + front.time < ans[p.node]){
                    ans[p.node] = p.time + front.time;
                    pq.add(new Pair(p.node,p.time + front.time));
                } 
            }
        }

        int max = -1;
        for(int i =1 ; i<=n ; i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            if(ans[i]>max){
                max = ans[i];
            }
        }
        return max;
        
    }
}