import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> isTravelNeeded = new HashSet<>();
    
    private int solve(int[] dp, int[] days, int[] costs, int currDay) {
        if (currDay > days[days.length - 1]) {
            return 0;
        }
        
        if (!isTravelNeeded.contains(currDay)) {
            return solve(dp, days, costs, currDay + 1);
        }
        
        if (dp[currDay] != -1) {
            return dp[currDay];
        }
        
        int oneDay = costs[0] + solve(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + solve(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + solve(dp, days, costs, currDay + 30);
        
        dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        return dp[currDay];
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        for (int i = 0; i <= lastDay; i++) {
            dp[i] = -1;
        }
        
        for (int day : days) {
            isTravelNeeded.add(day);
        }
        
        return solve(dp, days, costs, 1);
    }
}
