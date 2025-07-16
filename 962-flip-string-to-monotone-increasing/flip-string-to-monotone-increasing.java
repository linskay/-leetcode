class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, left[i] + right[i]);
        }
        return result;
    }
}