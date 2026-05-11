class Solution {
  String[] digitStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  List<String> res;
  public List<String> letterCombinations(String digits) {
    res = new ArrayList<>();

    if (digits.isEmpty()) {
      return res;
    }

    backTrack(digits, "", 0);
    return res;
  }

  public void backTrack(String digits, String currStr, int i) {
    if (currStr.length() == digits.length()) {
      res.add(currStr);
      return;
    }

    String digitSet = digitStr[digits.charAt(i) - '0'];

    for (char c : digitSet.toCharArray()) {
      backTrack(digits, currStr + c, i + 1);
    }
  }
}
