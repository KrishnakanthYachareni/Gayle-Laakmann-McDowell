package leetcode.learn.arrays;

/**
 * You are given an integer array nums where the largest integer is unique.
 * <p>
 * Determine whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, or return -1 otherwise.
 *
 * @link: https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
public class LargestNumber {
    public static void main(String[] args) {
        //Sample
    }

    public int dominantIndex(int[] nums) {
        int maxE = 0, maxI = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (maxE < nums[i] && flag) {
                maxE = nums[i];
                maxI = i;
            }
        }
        for (int x : nums) {
            if (x != maxE && maxE < 2 * x) {
                return -1;
            }
        }
        return maxI;
    }
}
