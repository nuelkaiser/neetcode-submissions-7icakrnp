class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int maxLength = 0;

        for(int num : nums) {
            seen.add(num);
        }        


        for(int num : nums) {
            if(!seen.contains(num - 1)) {
                int count = 1;

                while(seen.contains(num + count)) {
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}
