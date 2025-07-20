public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            time += distance(points[i], points[i + 1]);
        }
        return time;
    }

    private int distance(int[] p1, int[] p2) {
        return Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
    }
}