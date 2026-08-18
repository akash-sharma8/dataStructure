class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && !vis[0][i]) {
                dfs( 0, i,grid, vis);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs( i, m - 1,grid, vis);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (grid[n - 1][i] == 1 && !vis[n - 1][i]) {
                dfs( n - 1, i,grid, vis);
            }
        }
        for (int i = n - 2; i > 0; i--) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs( i, 0,grid, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    count++;
                }
            }

        }
        return count;
    }
   

    public void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == 0 || vis[i][j])
            return;
        vis[i][j] = true;
        dfs(i - 1, j, grid, vis);
        dfs(i + 1, j, grid, vis);
        dfs(i, j - 1, grid, vis);
        dfs(i, j + 1, grid, vis);
    }
}