import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k %= total;

        if (k == 0) {
            List<List<Integer>> result = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> newRow = new ArrayList<>();
                for (int val : row) {
                    newRow.add(val);
                }
                result.add(newRow);
            }
            return result;
        }

        int[] flatArray = new int[total];
        for (int i = 0; i < total; i++) {
            flatArray[i] = grid[i / n][i % n];
        }
        
        int[] newArray = new int[total];
        for (int i = 0; i < total; i++) {
            newArray[(i + k) % total] = flatArray[i];
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                newRow.add(newArray[i * n + j]);
            }
            result.add(newRow);
        }
        
        return result;
    }
}
