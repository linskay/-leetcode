public class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices) {
            return new ArrayList<>();
        }
        int total_jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int total_small = cheeseSlices - total_jumbo;
        return Arrays.asList(total_jumbo, total_small);
    }
}