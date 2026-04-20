class Solution {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> psum = new ArrayList<>();

    backTrack(nums, target, res, psum, 0);

    return res;
  }

  public void backTrack(int[] nums, int target, List<List<Integer>> res, List<Integer> psum, int i) {
    if(target == 0) {
      res.add(new ArrayList<>(psum));
      return;
    }

    if(i >= nums.length || target < 0) {
      return;
    }

    psum.add(nums[i]);
    backTrack(nums, target - nums[i], res, psum, i);

    psum.remove(psum.size() - 1);
    backTrack(nums, target, res, psum, i + 1);
  }
}
