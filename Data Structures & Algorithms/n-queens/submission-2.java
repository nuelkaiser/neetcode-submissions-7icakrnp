class Solution {
    Set<Integer> col;
    Set<Integer> postDiag;
    Set<Integer> negDiag;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        postDiag = new HashSet<>();
        negDiag = new HashSet<>();
        res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(n, board, 0);

        return res;
    }

    public void dfs(int n, char[][] board, int r) {
        if (r == n) {
            List<String> copy = new ArrayList<>();

            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || postDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            postDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            dfs(n, board, r + 1);

            col.remove(c);
            postDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}
