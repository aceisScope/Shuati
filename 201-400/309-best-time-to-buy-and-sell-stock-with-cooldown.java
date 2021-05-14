class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if (i == 1) {
                dp[1][1] = Math.max(-prices[0], -prices[1]);
            } else if (i >= 2) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            }
        }
        
        return dp[n-1][0];
    }
}

//dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])