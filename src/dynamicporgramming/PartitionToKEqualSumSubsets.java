package dynamicporgramming;

/**
 * Given an array arr of strictly positive integers, and an integer k,
 * create a function that returns the number of subsets of arr that sum up to k.
 */
public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 1};
        int ans = canPartitionKSubsets(ar, 4);
        System.out.println(ans);
    }

    /**
     * Tabulation (Bottom-up Approach)
     */
    public static int canPartitionKSubsets(int[] ar, int k) {
        int n = ar.length;
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        if (ar[0] <= k)
            dp[0][ar[0]] = 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - ar[i] >= 0) ? dp[i - 1][j - ar[i]] : 0);
            }
        return dp[n - 1][k];
    }

    /**
     * Recursive solution
     * TC = O(2^n)
     */
    public static int canPartitionKSubsetsRecursive(int[] nums, int k) {
        return recursiveSol(nums, k, 0);
    }

    private static int recursiveSol(int[] nums, int k, int i) {
        int n = nums.length;
        if (k == 0)
            return 1;
        if (i == n || k < 0)
            return 0;
        return recursiveSol(nums, k, i + 1) + recursiveSol(nums, k - nums[i], i + 1);
    }

}
