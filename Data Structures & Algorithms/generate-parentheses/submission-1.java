class Solution {
    List<String> res;
    StringBuilder stk;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        stk = new StringBuilder();

        backTrack(n, 0, 0);

        return res;
    }

    public void backTrack(int n, int open, int close) {
        if (open == n && open == close) {
            res.add(new String(stk));
        }

        if (open < n) {
            stk.append('(');
            backTrack(n, open + 1, close);
            stk.deleteCharAt(stk.length() - 1);
        }

        if (close < open) {
            stk.append(')');
            backTrack(n, open, close + 1);
            stk.deleteCharAt(stk.length() - 1);
        }
    }
}
