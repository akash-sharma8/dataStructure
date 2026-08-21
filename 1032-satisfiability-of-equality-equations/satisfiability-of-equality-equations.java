class Solution {
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
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i =0 ; i<26;i++){
            parent[i] = i;
        }

        for(String s : equations){
            if(s.charAt(1)=='!') continue;
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            int Pu = find(u);
            int Pv = find(v);
            if(Pu != Pv) union(u,v);
        }
        for(String s : equations){
            if(s.charAt(1)=='=') continue;
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            int Pu = find(u);
            int Pv = find(v);
            if(Pu==Pv) return false;
        }
        return true;
    }
}