import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        Set<String> rootSet = new HashSet<>(roots);
        
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            String replacement = word;
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(replacement);
        }
        
        return result.toString();
    }
}