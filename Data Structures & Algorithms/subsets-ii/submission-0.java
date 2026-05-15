class Solution {
    List<List<Integer>> res;
    List<Integer> set;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        set = new ArrayList<>();

        Arrays.sort(nums);
        
        backTrack(nums, 0);

        return res;
    }

    public void backTrack(int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        backTrack(nums, i + 1);
        set.remove(set.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backTrack(nums, i + 1);
    }
}
