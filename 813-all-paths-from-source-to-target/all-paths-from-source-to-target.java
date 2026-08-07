class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 0 ,graph, path);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int v , int[][] graph, List<Integer> path){
        path.add(v);
        if(v==graph.length-1) ans.add(new ArrayList<>(path));
        else{
            for(int a:graph[v]){
                dfs(ans, a , graph,path);
            }
        }
                path.remove(path.size()-1);
                return;
    }
}