class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        List<Integer>[] graph = new ArrayList[n];
        for(int i =0 ; i<n; i++){
            graph[i]= new ArrayList<>();
        }
        int[] res = new int[n];
        int[] indegree = new int[n];
        for(int[] edge: richer){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0 ; i<n; i++){
            if(indegree[i]==0) q.add(i);
            res[i] = i;
        }
        while(!q.isEmpty()){
            int u = q.remove();
            for(int v : graph[u]){
                if(quiet[v]>quiet[u]){
                    quiet[v]=quiet[u];
                    res[v] = res[u];
                }
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }
        return res;
    }
}