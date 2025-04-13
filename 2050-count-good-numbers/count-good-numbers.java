import java.math.BigInteger;

public class Solution {
    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        
        BigInteger five = BigInteger.valueOf(5);
        BigInteger four = BigInteger.valueOf(4);
        BigInteger mod = BigInteger.valueOf(MOD);
        
        BigInteger part1 = five.modPow(BigInteger.valueOf(evenCount), mod);
        BigInteger part2 = four.modPow(BigInteger.valueOf(oddCount), mod);
        
        BigInteger result = part1.multiply(part2).mod(mod);
        return result.intValue();
    }
}