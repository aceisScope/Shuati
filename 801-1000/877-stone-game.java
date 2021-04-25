class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                // 先手选择最左边或最右边的分数，下一次就是后手
                int left = piles[i] + dp[i+1][j].second; 
                int right = piles[i] + dp[i][j-1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i+1][j].first; // 先选择最左边，那么现在的后手就是下一次的先手
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j-1].first; 
                }
            }
        }


        return dp[0][n-1].first > dp[0][n-1].second;
    }
}

// dp[i][j].fir 表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数。
// dp[i][j].sec 表示，对于 piles[i...j] 这部分石头堆，后手能获得的最高分数。
// // base case dp[i][i]表示只有一堆的情况，先手获得全部
//  base case 是斜着的，而且推算 dp[i][j] 时需要用到 dp[i+1][j] 和 dp[i][j-1]，需要斜着遍历二维数组