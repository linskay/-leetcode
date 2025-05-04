class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}