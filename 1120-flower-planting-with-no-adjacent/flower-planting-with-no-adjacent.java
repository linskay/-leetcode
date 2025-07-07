import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0] - 1].add(path[1] - 1);
            graph[path[1] - 1].add(path[0] - 1);
        }
        
        int[] answer = new int[n];
        for (int garden = 0; garden < n; garden++) {
            boolean[] used = new boolean[5];
            for (int neighbor : graph[garden]) {
                used[answer[neighbor]] = true;
            }
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    answer[garden] = flower;
                    break;
                }
            }
        }
        
        return answer;
    }
}