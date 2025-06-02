class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s : S.toCharArray())
            for (char j : J.toCharArray())
                if (j == s) {
                    ans++;
                    break;
                }
        return ans;
    }
}