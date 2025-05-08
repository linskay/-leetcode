import java.util.PriorityQueue;

public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
 
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0, 1});
        
        int[][][] visited = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        visited[0][0][1] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int i = current[1];
            int j = current[2];
            int nextCost = current[3];
            
            if (i == n - 1 && j == m - 1) {
                return currentTime;
            }
            
            if (currentTime > visited[i][j][nextCost]) {
                continue;
            }
            
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    int requiredTime = Math.max(currentTime, moveTime[ni][nj]);
                    int newTime = requiredTime + nextCost;
                    int newNextCost = nextCost == 1 ? 2 : 1;
                    
                    if (newTime < visited[ni][nj][newNextCost]) {
                        visited[ni][nj][newNextCost] = newTime;
                        pq.offer(new int[]{newTime, ni, nj, newNextCost});
                    }
                }
            }
        }
        
        return -1;
    }
}