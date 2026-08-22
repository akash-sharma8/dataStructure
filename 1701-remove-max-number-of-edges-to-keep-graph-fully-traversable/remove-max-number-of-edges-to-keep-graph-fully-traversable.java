class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if(parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) {
                return false; 
            }

            if(rank[pa] < rank[pb]) {
                parent[pa] = pb;
            }
            else if(rank[pa] > rank[pb]) {
                parent[pb] = pa;
            }
            else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int used =0;
        for(int[] edge: edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(type==3){
                if(alice.union(u,v)){
                    bob.union(u,v);
                    used++;
                }
            }
        }
        for(int[] edge: edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(type == 1) {
                if(alice.union(u, v)) {
                    used++;
                }
            } else if(type == 2) {
                if(bob.union(u, v)) {
                    used++;
                }
            }
        }

        int rootAlice = alice.find(1);
        int rootBob = bob.find(1);

        for(int i = 2 ; i<=n ; i++){
            if(alice.find(i)!=rootAlice || bob.find(i)!=rootBob){
                return -1;
            }
        }
        return edges.length-used;
    }
}

//every node are visited by both alice and bob , either the node have type 3 edge , or type 1 and 2 both , if not then return -1, extra edges must be removed 
// if a node carry single edge either 1 or 2 then it must be removed 
// after removing edges if any node exist which have not type 3 edge  or type 1 & 2 both then return -1;
// connection in graph 
// connection means DSU, but in another format we take 2 dsu 