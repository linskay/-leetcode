class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minPos = -1, maxPos = -1, leftBound = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
                minPos = -1;
                maxPos = -1;
                continue;
            }
            
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            
            if (minPos != -1 && maxPos != -1) {
                res += Math.min(minPos, maxPos) - leftBound;
            }
        }
        
        return res;
    }
}