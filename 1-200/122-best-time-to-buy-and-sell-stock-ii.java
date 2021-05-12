class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        
        return dp[n-1][0];
    }
}

/*
dp[i][k][0 or 1]: 第i天，最多进行k次交易，手上不持有/持有股票
dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) 
此题目中 k 为无穷大，所以可以忽略
base case: dp[-1][0] = 0, dp[-1][1] = -infinity => dp[0][0] = =, dp[0][1] = -prices[0]
因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0. 而不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
*/