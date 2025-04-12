class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int m = n - k + 1;
        int[] subarraySums = new int[m];
        for (int i = 0; i < m; i++) {
            subarraySums[i] = prefixSum[i + k] - prefixSum[i];
        }
        
        int[] left = new int[m];
        int best = 0;
        for (int i = 0; i < m; i++) {
            if (subarraySums[i] > subarraySums[best]) {
                best = i;
            }
            left[i] = best;
        }

        int[] right = new int[m];
        best = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (subarraySums[i] >= subarraySums[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        int maxSum = 0;
        int[] result = new int[3];
        for (int j = k; j < m - k; j++) {
            int i = left[j - k];
            int l = right[j + k];
            int currentSum = subarraySums[i] + subarraySums[j] + subarraySums[l];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = i;
                result[1] = j;
                result[2] = l;
            } else if (currentSum == maxSum) {
                if (i < result[0] || (i == result[0] && j < result[1]) || (i == result[0] && j == result[1] && l < result[2])) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = l;
                }
            }
        }
        
        return result;
    }
}