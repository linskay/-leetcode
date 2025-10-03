public class Solution {
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    private long divideLong(long dividend, long divisor) {
        boolean negative = dividend < 0 != divisor < 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) return 0;

        long sum = divisor;
        long divide = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        long remaining = divideLong(dividend - sum, divisor);
        return negative ? -(divide + remaining) : (divide + remaining);
    }
}