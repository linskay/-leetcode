import java.util.Arrays;

public class Solution {
    public int maxSumDivThree(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 3 == 0) {
            return totalSum;
        }
        
        int mod1Min = Integer.MAX_VALUE;
        int mod2Min = Integer.MAX_VALUE;
        int[] mod1Min2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] mod2Min2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        for (int num : nums) {
            if (num % 3 == 1) {
                if (num < mod1Min2[1]) {
                    mod1Min2[1] = num;
                    Arrays.sort(mod1Min2);
                }
            } else if (num % 3 == 2) {
                if (num < mod2Min2[1]) {
                    mod2Min2[1] = num;
                    Arrays.sort(mod2Min2);
                }
            }
        }
        
        int result = 0;
        if (totalSum % 3 == 1) {
            result = totalSum - mod1Min2[0];
            if (mod2Min2[0] != Integer.MAX_VALUE && mod2Min2[1] != Integer.MAX_VALUE) {
                result = Math.max(result, totalSum - mod2Min2[0] - mod2Min2[1]);
            }
        } else if (totalSum % 3 == 2) {
            result = totalSum - mod2Min2[0];
            if (mod1Min2[0] != Integer.MAX_VALUE && mod1Min2[1] != Integer.MAX_VALUE) {
                result = Math.max(result, totalSum - mod1Min2[0] - mod1Min2[1]);
            }
        }
        
        return result;
    }
}