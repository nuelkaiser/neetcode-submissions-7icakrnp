class Solution {
    boolean[][] visited;
    int noOfIsland = 0;

    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    noOfIsland++;
                    dfs(r, c, grid);
                }
            }
        }
        return noOfIsland;
    }

    public void dfs(int r, int c, char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = true;

        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
