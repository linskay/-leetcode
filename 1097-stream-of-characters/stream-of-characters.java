import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

public class StreamChecker {
    private TrieNode root;
    private StringBuilder stream;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.isEndOfWord = true;
        }
    }

    public boolean query(char letter) {
        stream.insert(0, letter);
        TrieNode node = root;
        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
            if (node.isEndOfWord) return true;
        }
        return false;
    }
}
