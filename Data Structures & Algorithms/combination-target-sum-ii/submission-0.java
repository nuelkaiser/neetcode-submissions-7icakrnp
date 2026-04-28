class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    res = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates, target, new ArrayList<>(), 0, 0);
    return res;
  }

  public void dfs(int[] candidates, int target, List<Integer> sum, int total, int i) {
    if (total == target) {
      res.add(new ArrayList<>(sum));
      return;
    }

    if (i == candidates.length || total > target) {
      return;
    }

    sum.add(candidates[i]);
    dfs(candidates, target, sum, total + candidates[i], i + 1);
    sum.remove(sum.size() - 1);

    while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
      i++;
    }
    dfs(candidates, target, sum, total, i + 1);
  }
}
