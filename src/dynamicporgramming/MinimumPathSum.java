package dynamicporgramming;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int ans = minPathSum(grid);
        System.out.println(ans);
    }


    /**
     * Tabulation(Bottom-up Approach) with space optimization.
     * Time complexity = O(m * n)
     * Space complexity = O(m)
     * <p>
     */
    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m], prevDp = new int[m];
        prevDp[0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            prevDp[j] = grid[0][j] + prevDp[j - 1];
        }

        for (int i = 1; i < n; i++) {
            dp[0] = grid[i][0] + prevDp[0];

            for (int j = 1; j < m; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], prevDp[j]);
            }
            prevDp = dp;
        }
        return prevDp[m - 1];
    }

    /**
     * Tabulation(Bottom-up Approach)
     * Time complexity = O(m * n)
     * Space complexity = O(m * n)
     * <p>
     */
    public static int minPathSum2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = grid[0][0];

        // fill first column
        for (int i = 1; i < n; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        // fill first row
        for (int j = 1; j < m; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * Memoization(Top-down Approach)
     * Time complexity = O(m * n)
     * Space complexity = O(m * n)
     * <p>
     * Caller:
     * dp[][] = new int[n+1][m+1];
     * dp[][] = Arrays.fill(dp, -1);
     * minPathSum1(grid, 0, 0, dp)
     */
    public static int minPathSum1(int[][] grid, int i, int j, int[][] dp) {
        int n = grid.length, m = grid[0].length;
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (i == n - 1 && j == m - 1)
                dp[i][j] = grid[i][j];
            else if (j == m - 1)
                dp[i][j] = grid[i][j] + minPathSum1(grid, i + 1, j, dp);
            else if (i == n - 1)
                dp[i][j] = grid[i][j] + minPathSum1(grid, i, j + 1, dp);
            else
                dp[i][j] = grid[i][j] + Math.min(minPathSum1(grid, i, j + 1, dp), minPathSum1(grid, i + 1, j, dp));
        }
        return dp[i][j];
    }


    /**
     * Recursive approach to solve the path from top-left to bottom-right but this solution contains the
     * overlapping sub problems (DAG: Directed Acyclic Graph). Hence, need to apply dynamic programming.
     * <p>
     * Time complexity = O(2 ^ (m + n))
     */
    public static int solveRecurrence(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        else if (j == m - 1)
            return grid[i][j] + solveRecurrence(grid, i + 1, j);
        else if (i == n - 1)
            return grid[i][j] + solveRecurrence(grid, i, j + 1);
        else
            return grid[i][j] + Math.min(solveRecurrence(grid, i, j + 1), solveRecurrence(grid, i + 1, j));
    }
}
