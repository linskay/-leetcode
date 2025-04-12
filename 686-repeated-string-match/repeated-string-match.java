class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        while (S.length() < B.length()) {
            S.append(A);
            q++;
        }
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q + 1;
        return -1;
    }
}