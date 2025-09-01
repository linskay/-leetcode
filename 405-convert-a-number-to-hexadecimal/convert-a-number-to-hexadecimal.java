public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hexChars = "0123456789abcdef".toCharArray();
        long n = num;
        if (num < 0) n += 1L << 32;
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(hexChars[(int)(n % 16)]);
            n /= 16;
        }
        return result.reverse().toString();
    }
}