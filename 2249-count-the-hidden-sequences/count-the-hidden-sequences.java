public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long[] prefixSums = new long[n + 1];
        prefixSums[0] = 0;
        long minPrefix = 0;
        long maxPrefix = 0;
        
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += differences[i];
            prefixSums[i + 1] = currentSum;
            if (currentSum < minPrefix) {
                minPrefix = currentSum;
            }
            if (currentSum > maxPrefix) {
                maxPrefix = currentSum;
            }
        }
        
        long lowerBound = Math.max(lower, lower - minPrefix);
        long upperBound = Math.min(upper, upper - maxPrefix);
        
        if (upperBound < lowerBound) {
            return 0;
        } else {
            return (int) (upperBound - lowerBound + 1);
        }
    }
}