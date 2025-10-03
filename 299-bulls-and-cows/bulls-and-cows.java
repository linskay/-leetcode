import java.util.HashMap;
import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> h = new HashMap<>();
        for (char ch : secret.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }

        int bulls = 0;
        int cows = 0;
        int n = guess.length();
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();

        for (int idx = 0; idx < n; idx++) {
            char ch = guessArray[idx];
            if (h.containsKey(ch)) {
                if (ch == secretArray[idx]) {
                    bulls++;
                    if (h.get(ch) <= 0) {
                        cows--;
                    }
                } else {
                    if (h.get(ch) > 0) {
                        cows++;
                    }
                }
                h.put(ch, h.get(ch) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}