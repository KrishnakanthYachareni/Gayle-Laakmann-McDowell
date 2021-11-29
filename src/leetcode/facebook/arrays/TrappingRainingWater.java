package leetcode.facebook.arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainingWater {


    /**
     * Brute Force, time = O(n^2), space = O(1)
     * At every position in an array
     *
     * currentWater  = min(maxLeft, maxRight) - current Height
     *
     * Keep on doing this for all the elements in array and add them to maxWater
     */
    /*public int trap(int[] height) {
        int maxWater = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax(height, i), rightMax(height, i));
            int water = min - height[i];
            if (water >= 0) {
                maxWater += water;
            }
        }
        return maxWater;
    }

    private static int leftMax(int[] ar, int p) {
        int max = 0;
        for (int i = 0; i < p; i++) {
            max = Math.max(max, ar[i]);
        }
        return max;
    }

    private static int rightMax(int[] ar, int p) {
        int max = 0;
        for (int i = p + 1; i < ar.length; i++) {
            max = Math.max(max, ar[i]);
        }
        return max;
    }*/
}
