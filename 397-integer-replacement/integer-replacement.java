class Solution {
    public int integerReplacement(int n) {
        Map<Long, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }
    
    private int helper(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        
        if (n % 2 == 0) {
            memo.put(n, 1 + helper(n / 2, memo));
        } else {
            memo.put(n, 1 + Math.min(helper(n + 1, memo), helper(n - 1, memo)));
        }
        
        return memo.get(n);
    }
}