public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][2 * n - 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];

        for (int k = 1; k < 2 * n - 1; k++) {
            for (int i1 = Math.max(0, k - n + 1); i1 <= Math.min(n - 1, k); i1++) {
                for (int i2 = Math.max(0, k - n + 1); i2 <= Math.min(n - 1, k); i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 < n && j2 < n && grid[i1][j1] != -1 && grid[i2][j2] != -1) {
                        int maxCherries = Integer.MIN_VALUE;
                        if (i1 > 0 && i2 > 0) maxCherries = Math.max(maxCherries, dp[i1 - 1][i2 - 1][k - 1]);
                        if (i1 > 0) maxCherries = Math.max(maxCherries, dp[i1 - 1][i2][k - 1]);
                        if (i2 > 0) maxCherries = Math.max(maxCherries, dp[i1][i2 - 1][k - 1]);
                        maxCherries = Math.max(maxCherries, dp[i1][i2][k - 1]);
                        if (maxCherries != Integer.MIN_VALUE) {
                            dp[i1][i2][k] = maxCherries + grid[i1][j1];
                            if (i1 != i2) dp[i1][i2][k] += grid[i2][j2];
                        }
                    }
                }
            }
        }
        
        return Math.max(0, dp[n - 1][n - 1][2 * (n - 1)]);
    }
}