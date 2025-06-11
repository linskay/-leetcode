import java.util.*;

public class Solution {
    private boolean dfs(String word, int length, boolean[] visited, Set<String> dictionary) {
        if (length == word.length()) {
            return true;
        }
        if (visited[length]) {
            return false;
        }
        visited[length] = true;
        for (int i = word.length() - (length == 0 ? 1 : 0); i > length; --i) {
            if (dictionary.contains(word.substring(length, i)) && dfs(word, i, visited, dictionary)) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited, dictionary)) {
                answer.add(word);
            }
        }
        return answer;
    }
}