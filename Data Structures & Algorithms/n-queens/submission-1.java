class Solution {
  List<List<String>> res;
  Set<Integer> col;
  Set<Integer> postDiag;
  Set<Integer> negDiag;
  public List<List<String>> solveNQueens(int n) {
    res = new ArrayList<>();
    col = new HashSet<>();
    postDiag = new HashSet<>();
    negDiag = new HashSet<>();
    char[][] board = new char[n][n];

    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    backTrack(0, n, board);
    return res;
  }

  public void backTrack(int r, int n, char[][] board) {
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

      backTrack(r + 1, n, board);

      col.remove(c);
      postDiag.remove(r + c);
      negDiag.remove(r - c);
      board[r][c] = '.';
    }
  }
}
