class Solution {
  List<String> res;

  public List<String> generateParenthesis(int n) {
    res = new ArrayList<>();
    StringBuilder stk = new StringBuilder();

    backTrack(n, 0, 0, stk);
    return res;
  }

  public void backTrack(int n, int open, int close, StringBuilder stk) {
    if (open == close && open == n) {
      res.add(stk.toString());
      return;
    }

    if (open < n) {
      stk.append('(');
      backTrack(n, open + 1, close, stk);
      stk.deleteCharAt(stk.length() - 1);
    }

    if (close < open) {
      stk.append(')');
      backTrack(n, open, close + 1, stk);
      stk.deleteCharAt(stk.length() - 1);
    }
  }
}
