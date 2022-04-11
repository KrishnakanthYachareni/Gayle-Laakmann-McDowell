package leetcode.amazon.arrays;

//https://icpcarchive.ecs.baylor.edu/external/47/4787.pdf
public class RobotTravel {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int m = grid.length, n = grid[0].length;

        // Find the total cells,of every unique path
        boolean[][] visitedCells = new boolean[m][n];
        findSquaresEncountered(grid, 0, n - 1, visitedCells);

        int totalBlockedCells = countBlockedCells(grid);
        int squaresEncountered = countEncounteredCells(visitedCells);

        int result = (m * n) - squaresEncountered - totalBlockedCells;
        System.out.println(result); // 8
    }


    /**
     * Top-down Approach (Memoization)
     * <p>
     * Time Complexity : O(m * n)
     */
    public static void findSquaresEncountered(int[][] grid, int i, int j, boolean[][] visitedCells) {
        int m = grid.length;
        if (i != m && j != -1 && grid[i][j] != 1) {
            if (!visitedCells[i][j]) {
                visitedCells[i][j] = true;
                findSquaresEncountered(grid, i + 1, j, visitedCells);
                findSquaresEncountered(grid, i, j - 1, visitedCells);
            }
        }
    }

    private static int countEncounteredCells(boolean[][] grid) {
        int squaresEncountered = 0, n = grid[0].length;
        for (boolean[] row : grid)
            for (int j = 0; j < n; j++)
                if (row[j])
                    squaresEncountered++;
        return squaresEncountered;
    }

    private static int countBlockedCells(int[][] grid) {
        int squaresBlocked = 0, n = grid[0].length;
        for (int[] row : grid)
            for (int j = 0; j < n; j++)
                if (row[j] == 1)
                    squaresBlocked++;
        return squaresBlocked;
    }
}
