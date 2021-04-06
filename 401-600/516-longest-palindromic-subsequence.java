class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1 ; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[j][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}

// 在子串s[i..j]中，最长回文子序列的长度为dp[i][j]. i = j 时， 初始化为1； i > j时，初始化为0
// 状态转移表i为纵轴，j为横轴，由下向上由左到右遍历