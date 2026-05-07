class Solution {
  private List<String> res;
  private String[] digitStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    res = new ArrayList<>();

    if (digits.isEmpty()) {
      return res;
    }
    backtrack(digits, 0, "");

    return res;
  }

  public void backtrack(String digits, int i, String currStr) {
    if (currStr.length() == digits.length()) {
      res.add(currStr);
      return;
    }

    String chars = digitStr[digits.charAt(i) - '0'];

    for (char c : chars.toCharArray()) {
      backtrack(digits, i + 1, currStr + c);
    }
  }
}
