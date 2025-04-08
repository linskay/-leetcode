import java.util.HashSet;
import java.util.Set;

class Solution {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        int removedCount = 0;

        while (removedCount < n) {
            Set<Integer> seen = new HashSet<>();
            boolean isUnique = true;

            for (int i = removedCount; i < n; i++) {
                if (!seen.add(nums[i])) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                break;
            }

            removedCount += Math.min(3, n - removedCount);
            operations++;
        }

        return operations;
    }
}