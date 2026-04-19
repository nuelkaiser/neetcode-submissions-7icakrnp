class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r) {
            int currMax = Math.min(heights[l], heights[r]) * (r - l);
            if(heights[l] > heights[r]) {
                r--;
            }else {
                l++;
            }
            max = Math.max(max, currMax);
        }
        return max;
    }
}
