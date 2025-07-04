public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        if (s1Len > s2Len) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (int i = 0; i < s1Len; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2Len - s1Len; i++) {
            if (Arrays.equals(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + s1Len) - 'a']++;
        }
        
        return Arrays.equals(s1Count, s2Count);
    }
}
