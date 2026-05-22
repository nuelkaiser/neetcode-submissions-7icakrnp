class Solution {
    int maxArea = 0;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        visited = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int currentMaxArea = dfs(r, c, grid);
                    maxArea = Math.max(maxArea, currentMaxArea);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;

        if (r < 0 || c < 0 || r >= ROW || c >= COL || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int size = 1;

        size += dfs(r + 1, c, grid);
        size += dfs(r - 1, c, grid);
        size += dfs(r, c + 1, grid);
        size += dfs(r, c - 1, grid);

        return size;
    }
}
