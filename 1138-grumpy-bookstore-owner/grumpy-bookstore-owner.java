public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int additionalSatisfied = 0;
        int maxAdditionalSatisfied = 0;
        
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            } else {
                additionalSatisfied += customers[i];
            }
            
            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    additionalSatisfied -= customers[i - minutes];
                }
            }
            
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }
        
        return totalSatisfied + maxAdditionalSatisfied;
    }
}