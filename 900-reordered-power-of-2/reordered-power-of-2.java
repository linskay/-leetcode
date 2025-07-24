class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] A = Integer.toString(N).toCharArray();
        Arrays.sort(A);
        for (int i = 0; i < 30; ++i) {
            char[] B = Integer.toString(1 << i).toCharArray();
            Arrays.sort(B);
            if (Arrays.equals(A, B)) return true;
        }
        return false;
    }
}