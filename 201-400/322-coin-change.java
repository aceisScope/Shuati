class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; 
        Array.fills(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin: coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

// dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出. 为啥 dp 数组初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。