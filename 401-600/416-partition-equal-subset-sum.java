class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        sum = sum / 2;

        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j]; // 背包容量不足，不能装入第 i 个物品
                } else {
                    // 不把这第 i 个物品装入背包，那么是否能够恰好装满背包，取决于上一个状态 dp[i-1][j]
                    // 把这第 i 个物品装入了背包，那么是否能够恰好装满背包，取决于状态 dp[i-1][j-nums[i-1]]
                    dp[i][j] = dp[i-1][j]|| dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}

// dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
// 我们想求的最终答案就是 dp[N][sum/2]，base case 就是 dp[..][0] = true 和 dp[0][..] = false，因为背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包。