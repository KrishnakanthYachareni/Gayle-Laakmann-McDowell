package dynamicporgramming;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        int ans = minDistance(s1, s2);
        System.out.println(ans);
    }

    /**
     * Bottom-up: Tabulation approach.
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        /* First Row: each cell represents
        the number of characters so far in w1
         */
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        /* Second Column: each cell represents
        the number of characters so far w2 */
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        return dp[m][n];
    }


    /**
     * Brute force Recursion code for the edit distance
     * <p>
     * TC = O(3^n+m)
     */
    public int editDistance(String w1, String w2, int i, int j) {
        int m = w1.length(), n = w2.length();
        if (i == m) // if len of w1 > len of w2 (delete remaining chars in w1)
            return n - j;
        else if (j == n) // if len of w2 > len of w1 (insert remaining chars in w2)
            return m - i;
        else if (w1.charAt(i) == w2.charAt(j))
            return editDistance(w1, w2, i + 1, j + 1);
        else
            return 1 + Math.min(editDistance(w1, w2, i + 1, j), // delete char
                    Math.min(editDistance(w1, w2, i, j + 1), // insert char
                            editDistance(w1, w2, i + 1, j + 1))); // substitute
    }
}
