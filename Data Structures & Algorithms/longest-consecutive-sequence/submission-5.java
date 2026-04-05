class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int length = 0;

        for(int num : nums) {
            seen.add(num);
        }

        for(int num : nums) {
            if(!seen.contains(num - 1)) {
                int i = 1;
                while(seen.contains(num + i)) {
                    i++;
                }
                length = Math.max(length, i);
            }

        }
        return length;
    }
}
