package lastminute;

/**
 * Write a function that takes two inputs n and m and outputs the number of unique paths
 * from the top left corner to bottom right corner of n * m grid.
 * CConstraints: You can only move down or right 1 unit a time.
 */
public class UniquePathsInGrid {
    public static void main(String[] args) {
//        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int ans = solve(3, 4);
        System.out.println(ans);
    }

    static int solve(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return solve(n, m - 1) + solve(n - 1, m);
    }

}
