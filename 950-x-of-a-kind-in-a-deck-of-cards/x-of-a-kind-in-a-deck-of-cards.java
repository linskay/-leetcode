import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : deck) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int g = count.values().stream().reduce(this::gcd).orElse(0);
        return g > 1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}