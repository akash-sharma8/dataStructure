class Solution {
    public class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int count = 0;
    int fresh = 0;

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.offer(new Pair(i, j));

                if (grid[i][j] == 1)
                    fresh++;
            }
        }
        bfs(grid, q);

        if (fresh == 0)
            return count;
        return -1;
    }

    public void bfs(int[][] grid, Queue<Pair> q) {

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                Pair front = q.remove();
                int row = front.row, col = front.col;
                if (row > 0 && grid[row - 1][col] == 1) {
                    q.add(new Pair(row - 1, col));
                    grid[row - 1][col] = 2;
                    fresh--;
                }
                if (row < grid.length - 1 && grid[row + 1][col] == 1) {
                    q.add(new Pair(row + 1, col));
                    grid[row + 1][col] = 2;
                    fresh--;
                }
                if (col > 0 && grid[row][col - 1] == 1) {
                    q.add(new Pair(row, col - 1));
                    grid[row][col - 1] = 2;
                    fresh--;
                }
                if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
                    q.add(new Pair(row, col + 1));
                    grid[row][col + 1] = 2;
                    fresh--;
                }
            }

            if (!q.isEmpty())
                count++;

        }
    }
}