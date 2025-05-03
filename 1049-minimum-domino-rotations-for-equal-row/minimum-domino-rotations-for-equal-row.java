class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int result = Integer.MAX_VALUE;
        
        for (int candidate : new int[]{tops[0], bottoms[0]}) {
            int topRotations = 0;
            int bottomRotations = 0;
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (tops[i] != candidate && bottoms[i] != candidate) {
                    possible = false;
                    break;
                }
                if (tops[i] != candidate) {
                    topRotations++;
                }
                if (bottoms[i] != candidate) {
                    bottomRotations++;
                }
            }
            
            if (possible) {
                result = Math.min(result, Math.min(topRotations, bottomRotations));
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}