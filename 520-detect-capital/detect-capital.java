import java.util.regex.*;

class Solution {
    public boolean detectCapitalUse(String word) {
        String pattern = "[A-Z]*|.[a-z]*";
        return Pattern.matches(pattern, word);
    }
}