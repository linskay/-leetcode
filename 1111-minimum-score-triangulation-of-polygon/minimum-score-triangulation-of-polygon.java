public class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        
        // Создаем двумерный массив DP
        int[][] dp = new int[n][n];
        
        // Заполняем таблицу DP по диагоналям
        for (int length = 2; length < n; ++length) { // length — разница между i и j
            for (int i = 0; i < n - length; ++i) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Перебираем все возможные треугольники с вершинами i, k, j
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 
                                        dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}