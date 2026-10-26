class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    long s = dfs(grid, i, j);
                    if (s % k == 0)
                        count++;
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 0;
        }

        long sum = grid[i][j];

        grid[i][j] = 0;
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i, j - 1);
        sum += dfs(grid, i, j + 1);

        return sum;
    }
}