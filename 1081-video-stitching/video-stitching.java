import java.util.Arrays;

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int end = -1, end2 = 0, res = 0;
        
        for (int[] clip : clips) {
            if (end2 >= T || clip[0] > end2) break;
            if (end < clip[0] && clip[0] <= end2) {
                res++;
                end = end2;
            }
            end2 = Math.max(end2, clip[1]);
        }
        return end2 >= T ? res : -1;
    }
}