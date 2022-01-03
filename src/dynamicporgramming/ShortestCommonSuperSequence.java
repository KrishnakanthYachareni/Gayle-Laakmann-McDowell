package dynamicporgramming;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        int ans = scs("abac", "cab");
        System.out.println(ans);
    }

    /**
     * Bottom-Up (Tabulation)
     * <p>
     * TC = O(N*M), SC = O(N*M)
     */
    public static int scs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // First Row: each cell represents the number of characters so far s1
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        // Second Column: each cell represents the number of characters so far s2
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
