class Solution {
    public void solve(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 'O' && !vis[0][i]) {
                dfs( 0, i,grid, vis);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs( i, m - 1,grid, vis);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (grid[n - 1][i] == 'O' && !vis[n - 1][i]) {
                dfs( n - 1, i,grid, vis);
            }
        }
        for (int i = n - 2; i > 0; i--) {
            if (grid[i][0] == 'O' && !vis[i][0]) {
                dfs( i, 0,grid, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O' && vis[i][j] == false) {
                    grid[i][j]='X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == 'X' || vis[i][j])
            return;
        vis[i][j] = true;
        dfs(i - 1, j, grid, vis);
        dfs(i + 1, j, grid, vis);
        dfs(i, j - 1, grid, vis);
        dfs(i, j + 1, grid, vis);
    }
}