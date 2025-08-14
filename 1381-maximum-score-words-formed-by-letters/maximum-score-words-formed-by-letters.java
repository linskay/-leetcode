import java.util.*;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int maxScore = 0;
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch : letters) {
            letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < (1 << words.length); i++) {
            int currScore = 0;
            Map<Character, Integer> usedLetters = new HashMap<>();
            boolean valid = true;
            for (int j = 0; j < words.length; j++) {
                if ((i & (1 << j)) != 0) {
                    for (char ch : words[j].toCharArray()) {
                        usedLetters.put(ch, usedLetters.getOrDefault(ch, 0) + 1);
                        if (usedLetters.get(ch) > letterCount.getOrDefault(ch, 0)) {
                            valid = false;
                            break;
                        }
                        currScore += score[ch - 'a'];
                    }
                }
                if (!valid) break;
            }
            if (valid) {
                maxScore = Math.max(maxScore, currScore);
            }
        }

        return maxScore;
    }
}