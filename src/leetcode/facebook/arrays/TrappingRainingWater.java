package leetcode.facebook.arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainingWater {


    /**
     * If there is a larger bar at one end (say right), we are assured that the water trapped would be
     * dependent on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller,
     * we start iterating in opposite direction (from right to left).
     * <p>
     * Explanation: Max Trapping water is always depends on the minimum height of the bar Hence
     * <p>
     * Approach 4
     * https://leetcode.com/problems/trapping-rain-water/solution/
     */
    public int trap(int[] height) {
        int n = height.length;
        int maxWater = 0, maxLeft = 0, maxRight = height[n - 1];
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            if (height[p1] < height[p2]) {
                int currWater = maxLeft - height[p1];
                if (currWater >= 0) {
                    maxWater += currWater;
                }
                maxLeft = Math.max(maxLeft, height[p1]);
                p1++;
            } else {
                int currWater = maxRight - height[p2];
                if (currWater >= 0) {
                    maxWater += currWater;
                }
                maxRight = Math.max(maxRight, height[p2]);
                p2--;
            }
        }
        return maxWater;
    }

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
