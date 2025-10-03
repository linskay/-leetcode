import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights, directions);
            dfs(i, n - 1, atlantic, heights, directions);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights, directions);
            dfs(m - 1, j, atlantic, heights, directions);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights, int[][] directions) {
        ocean[r][c] = true;
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights, directions);
            }
        }
    }
}