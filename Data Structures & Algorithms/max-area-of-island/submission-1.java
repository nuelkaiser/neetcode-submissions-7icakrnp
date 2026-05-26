class Solution {
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int ROW = grid.length, COL = grid[0].length;
        visited = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int currentMax = dfs(r, c, grid);
                    maxArea = Math.max(maxArea, currentMax);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
    

        if (r < 0 || r >= ROW || c < 0 || c >= COL || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int res = 1;

        res += dfs(r + 1, c, grid);
        res += dfs(r - 1, c, grid);
        res += dfs(r, c + 1, grid);
        res += dfs(r, c - 1, grid);

        return res;
    }
}
