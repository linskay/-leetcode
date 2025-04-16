import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long totalPairs = 0;
        long res = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            int count = freq.getOrDefault(num, 0);
            totalPairs += count;
            freq.put(num, count + 1);
            
            while (totalPairs >= k) {
                res += nums.length - right;
                int leftNum = nums[left];
                int leftCount = freq.get(leftNum);
                totalPairs -= leftCount - 1;
                freq.put(leftNum, leftCount - 1);
                left++;
            }
        }
        
        return res;
    }
}