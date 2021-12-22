package dynamicporgramming;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {0, 0}};
        int ans = uniquePathsWithObstacles(mat);
        System.out.println(ans);
    }


    /**
     * Bottom Up Approach (Tabulation) with space optimization
     * TC = O(M * N), SC = O(1)
     * <p>
     * For the dp table can be used for same given matrix, Hence space id O(1)
     */
    public static int uniquePathsWithObstacles(int[][] grid) {
        // No Paths from the begging
        if (grid[0][0] == 1)
            return 0;

        int n = grid.length, m = grid[0].length;
        grid[0][0] = 1;
        // First Row
        for (int j = 1; j < m; j++)
            if (grid[0][j] == 0)
                grid[0][j] = grid[0][j - 1];
            else
                grid[0][j] = 0;

        // First column
        for (int i = 1; i < n; i++)
            if (grid[i][0] == 0)
                grid[i][0] = grid[i - 1][0];
            else
                grid[i][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid[n - 1][m - 1];
    }

    /**
     * Bottom Up Approach (Tabulation)
     * TC = O(M * N), SC = O(M * N)
     */
    public static int uniquePathsWithObstaclesBA(int[][] grid) {
        // No Paths from the begging
        if (grid[0][0] == 1)
            return 0;

        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        // First Row
        for (int j = 1; j < m; j++)
            if (grid[0][j] == 0)
                dp[0][j] = dp[0][j - 1];
            else
                dp[0][j] = 0;

        // First column
        for (int i = 1; i < n; i++)
            if (grid[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
            else
                dp[i][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * Top-Down Approach (Memoization)
     * TC = O(M * N), SC = O(M * N)
     */
    public static int uniquePathsWithObstacles(int[][] grid, int i, int j, int[][] dp) {
        int n = grid.length, m = grid[0].length;
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (i == n || j == m || grid[i][j] == 1)
                dp[i][j] = 0;
            else if (i == n - 1 && j == m - 1)
                dp[i][j] = 1;
            else
                dp[i][j] = uniquePathsWithObstacles(grid, i + 1, j, dp) + uniquePathsWithObstacles(grid, i, j + 1, dp);
        }
        return dp[i][j];
    }

    /**
     * Time complexity = O(2 ^ (M + N)), SC = O(M * N)
     */
    public int solveRecursion(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i == n || j == m || grid[i][j] == 1)
            return 0;
        else if (i == n - 1 && j == m - 1)
            return 1;
        else
            return solveRecursion(grid, i + 1, j) + solveRecursion(grid, i, j + 1);
    }
}
