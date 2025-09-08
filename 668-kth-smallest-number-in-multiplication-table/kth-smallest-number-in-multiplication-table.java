public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (countLessEqual(m, n, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int countLessEqual(int m, int n, int x) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }
}
