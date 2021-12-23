package dynamicporgramming;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] ar = {2, 7, 9, 3, 1};
        int ans = rob(ar);
        System.out.println(ans);
    }

    /**
     * Bottom-up Approach (Tabulation)
     * Time Complexity = O(N), SPace Complexity = O(N)
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    /**
     * Top-down approach (Memoization)
     * <p>
     * TC = O(n), SC = O(n)
     */
    public static int robRecursion(int[] nums, int i, int[] dp) {
        int n = nums.length;
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        } else
            dp[i] = Math.max(nums[i] + robRecursion(nums, i + 2, dp), robRecursion(nums, i + 1, dp));
        return dp[i];
    }

    /**
     * Simple recursion, either we can take the current element or start from the next index
     * TC = O(2^n)
     */
    public static int robRecursion(int[] nums, int i) {
        int n = nums.length;
        if (i >= n) {
            return 0;
        }
        return Math.max(nums[i] + robRecursion(nums, i + 2), robRecursion(nums, i + 1));
    }
}
