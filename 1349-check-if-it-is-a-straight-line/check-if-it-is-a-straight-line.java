public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        
        for (int[] point : coordinates) {
            int x = point[0], y = point[1];
            if ((x1 - x0) * (y - y0) != (y1 - y0) * (x - x0)) {
                return false;
            }
        }
        return true;
    }
}