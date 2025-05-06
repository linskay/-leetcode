public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int hold = -prices[0];
        int sold = 0;
        int cooldown = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int newHold = Math.max(hold, cooldown - prices[i]);
            int newSold = hold + prices[i];
            int newCooldown = Math.max(cooldown, sold);
            
            hold = newHold;
            sold = newSold;
            cooldown = newCooldown;
        }
        
        return Math.max(sold, cooldown);
    }
}