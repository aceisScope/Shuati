class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0, dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][i] + prices[i]); // 无操作或卖出
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]); // 无操作或买入
        }

        return dp[n-1][0];
    }
}

/*
dp[i][k][0 or 1]: 第i天，最多进行k次交易，手上不持有/持有股票
dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) 
此题目中 k = 1
base case: dp[-1][0] = 0, dp[-1][1] = -infinity
*/