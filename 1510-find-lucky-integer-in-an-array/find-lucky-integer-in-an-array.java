class Solution {
    public int findLucky(int[] arr) {
        
    Map<Integer, Integer> counts = new HashMap<>();
    for (Integer num : arr) {
        counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    
    int largestLuckyNumber = -1;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        if (entry.getKey().equals(entry.getValue())) {
            largestLuckyNumber = Math.max(largestLuckyNumber, entry.getKey());
        }
    }
    
    return largestLuckyNumber;
}
}