public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = i;
                int count = 0;
                while (!visited[start]) {
                    visited[start] = true;
                    start = nums[start];
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        
        return maxLength;
    }
}