class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pans = new ArrayList<>();

        dfs(nums, target, res, pans, 0);

        return res;       
    }

    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> pans, int i) {
        if(target == 0) {
            res.add(new ArrayList<>(pans));
            return;
        }

        if(target < 0 || i >= nums.length) {
            return;
        }

        pans.add(nums[i]);
        dfs(nums, target - nums[i], res, pans, i);

        pans.remove(pans.size() - 1);
        dfs(nums, target, res, pans, i + 1);
    }
}
