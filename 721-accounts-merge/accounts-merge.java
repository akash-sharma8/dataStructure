class Solution {
    int[] parent;
    int[] rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];
        for(int i =0 ; i<n ; i++){
            parent[i]=i;
        }

        Map<String , Integer> ETA = new HashMap<>();
        for(int i =0 ; i<n ; i++){
            for(int j = 1; j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(ETA.containsKey(email)){
                    int oldAccount = ETA.get(email);
                    union(i,oldAccount);
                }else{
                    ETA.put(email , i);
                }
            }
        }

        Map<Integer,List<String>> groups = new HashMap<>();
        for(String email: ETA.keySet()){
            int account = ETA.get(email);
            int root = find(account);
            groups.computeIfAbsent(root, k-> new ArrayList<>()).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int root: groups.keySet()){
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            account.add(accounts.get(root).get(0));
            account.addAll(emails);
            ans.add(account);
        }
return ans;
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