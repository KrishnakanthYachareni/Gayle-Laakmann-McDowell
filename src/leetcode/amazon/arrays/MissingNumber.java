package leetcode.amazon.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        return (n * (n + 1) / 2) - Arrays.stream(nums).sum();
    }
}
