class Solution {

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1+ dfs(i - 1, j, grid) + dfs(i + 1, j, grid) +dfs(i, j - 1, grid) + dfs(i , j + 1, grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
    int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   
                    max = Math.max(max,  dfs(i, j, grid));
                }
            }
        }
        return max;
    }
}