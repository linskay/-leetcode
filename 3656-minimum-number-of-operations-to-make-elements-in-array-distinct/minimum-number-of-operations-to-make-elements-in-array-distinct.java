public class Solution {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        int removedCount = 0;

        while (removedCount < n) {
            if (isUnique(nums, removedCount)) {
                break; 
            }

            removedCount += Math.min(3, n - removedCount);
            operations++;
        }

        return operations;
    }

    private boolean isUnique(int[] nums, int start) {
        int[] frequency = new int[101];

        for (int i = start; i < nums.length; i++) {
            frequency[nums[i]]++;
            if (frequency[nums[i]] > 1) {
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7})); // Output: 2
        System.out.println(solution.minimumOperations(new int[]{4, 5, 6, 4, 4}));            // Output: 2
        System.out.println(solution.minimumOperations(new int[]{6, 7, 8, 9}));               // Output: 0
    }
}