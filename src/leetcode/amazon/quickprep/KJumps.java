package leetcode.amazon.quickprep;

public class KJumps {
    /**
     * if you are in (x,y). you can go to (x+i,y+j) grid where i+j>0(any posible i value ,j value .
     * you want go to (m,n) from(0,0) in exactly k jumps.return no of different ways to reach the last grid(m,n)
     * TESTCASE1 :m=2
     * n=2
     * k=2
     * OUTPUT:7 ways
     * explanation :
     * (0,0)->(1,1)->(2,2)
     * (0,0)->(1,2)->(2,2)
     * (0,0)->(2,1)->(2,2).............so on
     * TESTCASE2:m=4n=5
     * k=22
     * OUTPUT:0
     * you cannot move by exactly k jumps .
     * important to note:(optimisation is necessary can any one solve)
     * CONSTRAINTS:0<m<200
     * 0<n<200
     * 0<k<200
     */
    public static void main(String[] args) {
        int m = 3, n = 3, k = 3;
        Integer[][][] dp = new Integer[m][n][k + 1];
        System.out.println(findWays(m - 1, n - 1, k, dp));
    }

    public static int findWays(int m, int n, int k, Integer[][][] dp) {

        // Return 0 if either of m or n are less than 0 (out of boundary)
        // or if k is less than 0 (i.e more jumps than required)
        if (m < 0 || n < 0 || k < 0) {
            return 0;
        }

        // Base case if m and n are 0 and k is also exactly 0 (in k steps reaches (0,0))
        if (m == 0 && n == 0 && k == 0) {
            return 1;
        }

        // If answer is stored previously return answer
        if (dp[m][n][k] != null) {
            return dp[m][n][k];
        }

        int ways = 0;

        // Try out for all the possible jumps
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Ignore the case when i and j are 0 since i + j > 0 according to
                // condition
                if (i == 0 && j == 0)
                    continue;
                    // calculate no. of ways for every possiblity and add to ways
                else ways += findWays(m - i, n - j, k - 1, dp);
            }
        }

        return dp[m][n][k] = ways;
    }

}
