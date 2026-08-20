class Solution {
    int[] parent;
    int[] rank ;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];

        for(int i =0 ; i<n; i++){
            parent[i]=i;
        }
        int components = n;

        for(int i =0; i<n ; i++){
            for(int j = i+1; j<n ; j++){
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {
                    if (find(i) != find(j)) {
                        union(i, j);
                        components--;
                    }
                }
            }
        }
        return n-components;
    }
    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] < rank[rootB]) {
        parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}