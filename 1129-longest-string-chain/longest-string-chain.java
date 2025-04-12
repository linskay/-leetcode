import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 1;
        
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String predecessor = sb.deleteCharAt(i).toString();
                if (dp.containsKey(predecessor)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(predecessor) + 1));
                }
            }
            longestChain = Math.max(longestChain, dp.get(word));
        }
        
        return longestChain;
    }
}