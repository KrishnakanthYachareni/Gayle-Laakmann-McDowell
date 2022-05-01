package dynamicporgramming;

import java.util.Scanner;

public class LevenshteinDistance {

    /**
     * sunday, saturday  -> 3
     * AGGCTATCACCTGACCTCCAGGCCGATGCCC, TAGCTATCACGACCGCGGTCGATTTGCCCGAC -> 13
     *
     */
    public static void main(String[] args) {
//        String s1 = "intention", s2 = "execution";
        System.out.println("Enter two strings");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[][] decisionTable = minDistance(s1, s2);
        System.out.println("Minimum Edit distance is: " + decisionTable[s1.length()][s2.length()]);
        System.out.println("Operations are: ");
        printChanges(s1, s2, decisionTable);
    }

    /**
     * Bottom-up: Tabulation approach.
     */
    public static int[][] minDistance(String word1, String word2) {
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
        return dp;
    }

    public static void printChanges(String s1, String s2, int[][] decisionTable) {
        int i = s1.length(), j = s2.length();
        while (i != 0 && j != 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            } else if (decisionTable[i][j] == decisionTable[i - 1][j - 1] + 1) { // Replace the character
                System.out.println("Substitute " + s1.charAt(i - 1) + " with " + s2.charAt(j - 1));
                i--;
                j--;
            } else if (decisionTable[i][j] == decisionTable[i - 1][j] + 1) { // Delete the character
                System.out.println("Delete " + s1.charAt(i - 1));
                i--;
            } else if (decisionTable[i][j] == decisionTable[i][j - 1] + 1) { // Insert the character
                System.out.println("Insert " + s2.charAt(j - 1));
                j--;
            }
        }
    }
}
