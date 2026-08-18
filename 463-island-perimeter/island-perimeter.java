class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null ) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                  return  dfs(i, j, grid);
                }
            }
        }
        return 0;

    }

     public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 1;
    
         if (grid[i][j] == -1) return 0;
        int count = 0;
        grid[i][j] = -1;
        
        count += dfs( i-1, j,grid);
        count += dfs( i, j-1,grid);
        count += dfs( i, j+1,grid);
        count += dfs( i+1, j,grid);
        
        return count;
    }
}