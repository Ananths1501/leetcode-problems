import java.util.Arrays;

class Solution {

    public int f(int i, int j, String w1, String w2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = 1 + f(i - 1, j - 1, w1, w2, dp);
        }
        return dp[i][j] = Math.max(f(i - 1, j, w1, w2, dp), f(i, j - 1, w1, w2, dp));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lcs = f(m - 1, n - 1, word1, word2, dp);

        return (m - lcs) + (n - lcs);
    }
}
