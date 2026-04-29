class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxF = 0;
        int maxLength = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            maxF = Math.max(maxF, map.get(s.charAt(r)));

            if((r - l + 1) - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }        
        return maxLength;
    }
}
