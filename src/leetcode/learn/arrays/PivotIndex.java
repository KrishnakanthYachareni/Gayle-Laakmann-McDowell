package leetcode.learn.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>
 * Problem: https://leetcode.com/problems/find-pivot-index/
 * <p>
 * Solution:
 * We need to quickly compute the sum of values to the left and the right of every index.
 * <p>
 * Let's say we knew S as the sum of the numbers, and we are at index i.
 * If we knew the sum of numbers leftsum that are to the left of index i,
 * then the other sum to the right of the index would just be S - nums[i] - leftsum.
 * <p>
 * TC: O(N), SC = O(1)
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int ans = new PivotIndex().pivotIndex(nums);
        System.out.println(ans);
    }

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
