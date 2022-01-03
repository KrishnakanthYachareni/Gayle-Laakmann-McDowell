package dynamicporgramming;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        int ans = longestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }

    /**
     * Bottom-Up (Tabulation)
     * <p>
     * TC = O(N*M), SC = O(N*M)
     */
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // First row and columns are filled with 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

}
