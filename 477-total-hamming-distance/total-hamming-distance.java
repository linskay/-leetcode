public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        
        if (nums.length == 0) {
            return ans;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        
        return ans;
    }
}
