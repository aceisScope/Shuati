class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // base case 凑出的目标金额为 0
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j > coins[i-1]) {
                    // 如果不把这第 i 个物品装入背包，也就是说不使用 coins[i] 这个面值的硬币，那么凑出面额 j 的方法数 dp[i][j] 应该等于 dp[i-1][j]，继承之前的结果
                    // 如果把这第 i 个物品装入了背包，也就是说使用 coins[i] 这个面值的硬币，那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]], 因为i物品可以重复使用
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else{
                    dp[i][j] = dp[j-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}

// dp[i][j]的定义为若只使用前 i 个物品，当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包