import java.util.ArrayList;
import java.util.List;

class CombinationIterator {
    private List<String> combinations;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        int n = characters.length();
        int k = combinationLength;
        for (int bitmask = 0; bitmask < (1 << n); ++bitmask) {
            if (Integer.bitCount(bitmask) == k) {
                StringBuilder curr = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if ((bitmask & (1 << (n - j - 1))) != 0) {
                        curr.append(characters.charAt(j));
                    }
                }
                combinations.add(curr.toString());
            }
        }
    }

    public String next() {
        return combinations.remove(combinations.size() - 1);
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}