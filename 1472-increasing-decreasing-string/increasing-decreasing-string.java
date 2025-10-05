import java.util.*;

public class Solution {
    public String sortString(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        while (result.length() < s.length()) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (charCount[c - 'a'] > 0) {
                    result.append(c);
                    charCount[c - 'a']--;
                }
            }
            for (char c = 'z'; c >= 'a'; c--) {
                if (charCount[c - 'a'] > 0) {
                    result.append(c);
                    charCount[c - 'a']--;
                }
            }
        }
        
        return result.toString();
    }
}