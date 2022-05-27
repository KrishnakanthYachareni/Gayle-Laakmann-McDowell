package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[nonZero++] = nums[i];
        }

        while (nonZero < nums.length) {
            nums[nonZero++] = 0;
        }
    }
}
