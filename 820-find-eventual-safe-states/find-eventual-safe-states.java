class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i<graph.length;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i =0 ; i<n; i++){
            for(int ele: graph[i]){
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i<n ; i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int front = q.remove();
            list.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
    Collections.sort(list);
        return list;
    }
}