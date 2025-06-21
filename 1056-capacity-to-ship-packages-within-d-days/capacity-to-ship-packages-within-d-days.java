public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canShipInDays(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canShipInDays(int[] weights, int D, int capacity) {
        int days = 1, total = 0;
        for (int weight : weights) {
            if (total + weight > capacity) {
                days++;
                total = 0;
            }
            total += weight;
        }
        return days <= D;
    }
}