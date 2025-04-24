class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int left = 0;
        int right = 1;

        while (right < n) {
            if (nums[right] != nums[left]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }

        return left + 1;
    }
}