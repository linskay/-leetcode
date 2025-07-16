public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();
        
        while (a > 0 || b > 0) {
            if (result.length() >= 2 && result.charAt(result.length() - 1) == result.charAt(result.length() - 2)) {
                if (result.charAt(result.length() - 1) == 'a') {
                    result.append('b');
                    b--;
                } else {
                    result.append('a');
                    a--;
                }
            } else {
                if (a >= b) {
                    result.append('a');
                    a--;
                } else {
                    result.append('b');
                    b--;
                }
            }
        }
        
        return result.toString();
    }
}