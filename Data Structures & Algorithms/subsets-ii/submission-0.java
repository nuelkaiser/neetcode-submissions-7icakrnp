class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();

    Arrays.sort(nums);

    dfs(nums, set, 0);

    return res;
  }

  public void dfs(int[] nums, List<Integer> set, int i) {
    if (i == nums.length) {
      res.add(new ArrayList<>(set));
      return;
    }

    set.add(nums[i]);
    dfs(nums, set, i + 1);
    set.remove(set.size() - 1);

    while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
      i++;
    }
    dfs(nums, set, i + 1);
  }
}
