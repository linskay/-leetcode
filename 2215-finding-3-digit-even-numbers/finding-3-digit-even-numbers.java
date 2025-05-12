import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;
   
                    if (digits[i] != 0 && digits[k] % 2 == 0) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        result.add(num);
                    }
                }
            }
        }
        
        List<Integer> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);

        int[] answer = new int[sortedList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sortedList.get(i);
        }
        
        return answer;
    }
}