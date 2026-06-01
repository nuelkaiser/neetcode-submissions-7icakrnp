class Solution {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                int r = rotten[0];
                int c = rotten[1];

                for (int[] dir : dirs) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
                        continue;
                    }
                    q.add(new int[] {row, col});
                    grid[row][col] = 2;
                    rotted = true;
                }
            }
            if (rotted) {
                min++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
