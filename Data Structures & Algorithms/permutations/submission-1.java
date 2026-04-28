class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    dfs(nums, new ArrayList<>(), new boolean[nums.length]);

    return res;
  }

  public void dfs(int[] nums, List<Integer> curr, boolean[] pick) {
    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (pick[i])
        continue;
      pick[i] = true;
      curr.add(nums[i]);
      dfs(nums, curr, pick);
      curr.remove(curr.size() - 1);
      pick[i] = false;
    }
  }
}
