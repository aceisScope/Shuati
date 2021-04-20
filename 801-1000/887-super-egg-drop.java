class Solution {
    public int superEggDrop(int k, int n) {
        if (k == 1) return n; // 只有一个鸡蛋，只能线性尝试
        if (n == 1) return 1;
    }

    int[][] dp = new int[k+1][n+1];

    for (int i = 1; i <= k; i++) { // 楼层数为1时，无论有多少个鸡蛋最小尝试次数肯定是1
        dp[i][1] = 1; 
    }
    for (int j = 1; j <= n; j++) { // 鸡蛋数是1时，有多少层楼最小尝试次数就是多少
        dp[1][j] = j;
    }

    for (int i = 2; i <= k; i++) {
        for (int j = 2; j <= n; j++) {
            int low = 1, high = j;
            while (low < high) {
                if (low + 1 == high) {
                    break;
                }
                int mid = (low + high) / 2;
                if (dp[i-1][mid-1] > dp[i][j-mid]) {  // x 太大了
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }

            dp[i][j] = Math.min(
                    Math.max(dp[i-1][low-1], dp[i][j-low]), 
                    Math.max(dp[i-1][low], dp[i][j-low-1])
                ) + 1;
        }
    }

    return dp[k][n];
}

// dp[i][j] 表示有 i 个鸡蛋 j 层楼时最坏情况下的最小尝试次数

// 1. 在x楼层，扔下来没碎，那么往上走一层 dp[i][j-x] 2. 扔下来碎了，鸡蛋减1，往下走一层 dp[i-1][x-1]
// 则有 dp[i][j] = min{max{dp[i-1][x-1], dp[i][j-x]}, x = 1,...,j} + 1 

// dp[i-1][x-1] 是 x 的单调递增函数， dp[i][j-x] 是 x 的单调递减函数，所以一定是在交点处 max{dp[i-1][x-1], dp[i][j-x]} 最小。由于 x 是散列的整数，所以只需要找到离交点最近的两个 x 值中的最小值
// 使用二分搜索优化 x=1,...j 的遍历 http://devgou.com/article/LeetCode.887.SuperEggDrop/