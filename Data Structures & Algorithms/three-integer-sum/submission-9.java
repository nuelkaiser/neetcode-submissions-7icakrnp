class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();

        Arrays.sort(nums);


        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1; 
            int r = nums.length -1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if(sum < 0) {
                    l++;
                }else if(sum > 0) {
                    r--;
                }else {
                    sums.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    l++;
                    r--;
                    
                    while(l < r && nums[l] == nums[l - 1]) l++;
                    while(r > l && nums[r] == nums[r + 1]) r--;
                }
            }


        }  
        return sums;   
    }
}
