public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int res = 0, left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) count++;
            while (count > k) {
                if (nums[left++] % 2 == 1) count--;
            }
            res += right - left + 1;
        }
        return res;
    }
}
