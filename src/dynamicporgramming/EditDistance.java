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
        // First Row: each cell represents the number of characters so far word1
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        // Second Column: each cell represents the number of characters so far word2
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        return dp[m][n];
    }


    /**
     * Brute force Recursion code for the edit distance
     * <p>
     * TC = O(3^n+m)
     */
    public int minDistanceRec(String s1, String s2, int i, int j) {
        int m = s1.length(), n = s2.length();
        if (i == m) // if len of s1 > len of s2 (delete remaining chars in s1)
            return n - j;
        else if (j == n) // if len of s2 > len of s1 (insert remaining chars in s2)
            return m - i;
        else if (s1.charAt(i) == s2.charAt(j))
            return minDistanceRec(s1, s2, i + 1, j + 1);
        else
            return 1 + Math.min(minDistanceRec(s1, s2, i + 1, j), // delete char
                    Math.min(minDistanceRec(s1, s2, i, j + 1), // insert chat
                            minDistanceRec(s1, s2, i + 1, j + 1))); // substitute
    }
}
