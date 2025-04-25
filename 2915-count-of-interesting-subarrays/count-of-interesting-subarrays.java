class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        long result = 0;
        int currentPrefix = 0;
        
        for (int num : nums) {
            if (num % modulo == k) {
                currentPrefix = (currentPrefix + 1) % modulo;
            }
            int target = (currentPrefix - k + modulo) % modulo;
            result += prefixCount.getOrDefault(target, 0);
            prefixCount.put(currentPrefix, prefixCount.getOrDefault(currentPrefix, 0) + 1);
        }  
        return result;
    }
}