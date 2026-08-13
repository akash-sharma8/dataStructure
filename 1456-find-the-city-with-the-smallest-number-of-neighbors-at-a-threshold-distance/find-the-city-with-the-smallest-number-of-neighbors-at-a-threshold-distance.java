class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int k =0; k<n;k++){
            for(int  i =0; i<n; i++){
                if(i==k) continue;
                for(int j =0 ; j<n; j++){
                    if(j==k) continue;
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) 
                    dist[i][j] = Math.min(dist[i][j], dist[k][i]+ dist[j][k]);
                }
            }
        }

        int mincity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i =0 ; i<n; i++){
            int count=0;
            for(int j =0 ; j<n ; j++){
                if(i==j) continue;
                if(dist[i][j]<=threshold){
                    count++;
                }
            }
            if(count<=minCount){
                mincity =i;
                minCount = count;
            }
        }
        return mincity;

    }
}