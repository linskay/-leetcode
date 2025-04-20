class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int ans : answers) {
            count.put(ans, count.getOrDefault(ans, 0) + 1);
        }
        
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            int groups = (v + k) / (k + 1);
            total += groups * (k + 1);
        }
        return total;
    }
}