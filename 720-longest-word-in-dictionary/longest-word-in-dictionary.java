import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> validWords = new HashSet<>();
        validWords.add("");
        String longest = "";
        for (String word : words) {
            if (validWords.contains(word.substring(0, word.length() - 1))) {
                validWords.add(word);
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}