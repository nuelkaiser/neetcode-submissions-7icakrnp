class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<Integer> sum = new ArrayList<>();
    res = new ArrayList<>();
    ;
    Arrays.sort(nums);

    backTrack(nums, sum, 0);

        return res;
  }

  public void backTrack(int[] nums, List<Integer> sum, int i) {
    if (i == nums.length) {
      res.add(new ArrayList<>(sum));
      return;
    }

    sum.add(nums[i]);
    backTrack(nums, sum, i + 1);
    sum.remove(sum.size() - 1);

    while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
      i++;
    }
    backTrack(nums, sum, i + 1);
  }
}
