import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            sumCount.put(digitSum, sumCount.getOrDefault(digitSum, 0) + 1);
        }
        
        int maxSize = 0;
        for (int count : sumCount.values()) {
            if (count > maxSize) {
                maxSize = count;
            }
        }
        
        int result = 0;
        for (int count : sumCount.values()) {
            if (count == maxSize) {
                result++;
            }
        }
        
        return result;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}