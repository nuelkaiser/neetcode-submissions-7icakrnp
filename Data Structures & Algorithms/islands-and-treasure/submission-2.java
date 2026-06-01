class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if (q.size() == 0)
            return;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for (int[] dir : dirs) {
                int row = r + dir[0];
                int col = c + dir[1];

                if (row >= m || row < 0 || col >= n || col < 0 || grid[row][col] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(new int[] {row, col});
                grid[row][col] = grid[r][c] + 1;
            }
        }
    }
}
