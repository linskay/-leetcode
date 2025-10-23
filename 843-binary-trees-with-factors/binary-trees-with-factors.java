class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        Arrays.sort(A);
        long[] dp = new long[A.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> index = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            index.put(A[i], i);
        }
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }
        
        long result = 0;
        for (long x : dp) {
            result = (result + x) % MOD;
        }
        return (int) result;
    }
}