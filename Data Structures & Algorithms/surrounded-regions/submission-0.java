class Solution {
    public void solve(char[][] board) {
        int ROW = board.length, COL = board[0].length;

        for (int r = 0; r < ROW; r++) {
            if (board[r][0] == 'O') {
                capture(board, r, 0);
            }

            if (board[r][COL - 1] == 'O') {
                capture(board, r, COL -1);
            }
        }

        for (int c = 0; c < COL; c++) {
            if (board[0][c] == 'O') {
                capture(board, 0, c);
            }

            if (board[ROW - 1][c] == 'O') {
                capture(board, ROW - 1, c);
            }
        }

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void capture(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}
