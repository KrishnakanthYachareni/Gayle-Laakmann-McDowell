package algoexpert.dp;

/*
https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /*
       Approach: Kadane's Algorithm
       TC = O(N), SC = O(1)
   */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maximumSubArray = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maximumSubArray = Math.max(maximumSubArray, currentSum);
        }
        return maximumSubArray;
    }
}
