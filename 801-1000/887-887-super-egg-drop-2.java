class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for (int m = 1; dp[k][m] < n; m++) {
            for (int j = 1; j < k; j++) {
                dp[j][m] = dp[j][m-1] + dp[j-1][m-1] + 1;
            }
        }

        return m;
    }
}

/* 
dp[k][m] = n: 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋, 这个状态下，最坏情况下最多能确切测试一栋 n 层的楼. m 是一个允许的次数上界.
dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
dp[k][m - 1] 就是楼上的楼层数，因为鸡蛋个数 k 不变，也就是鸡蛋没碎，扔鸡蛋次数 m 减一；
dp[k - 1][m - 1] 就是楼下的楼层数，因为鸡蛋个数 k 减一，也就是鸡蛋碎了，同时扔鸡蛋次数 m 减一。
*/