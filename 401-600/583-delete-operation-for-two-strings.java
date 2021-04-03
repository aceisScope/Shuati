class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word2, word1);
        return word1.length() - lcs + word2.length() - lcs;
    }

    // 最长公共子序列
    int[][] memo;
    int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) return 0;
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }      
        
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i+1, s2, j+1);
        } else {
            memo[i][j] = Math.max(
                dp(s1, i+1, s2, j),
                dp(s1, i, s2, j+1)
            );
        }
        return memo[i][j];
    }
}