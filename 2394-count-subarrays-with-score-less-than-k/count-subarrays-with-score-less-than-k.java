class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        long res = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            long currentSum = prefix[right + 1] - prefix[left];
            int length = right - left + 1;
            while (currentSum * length >= k && left <= right) {
                left++;
                currentSum = prefix[right + 1] - prefix[left];
                length = right - left + 1;
            }
            res += right - left + 1;
        }
        return res;
    }
}