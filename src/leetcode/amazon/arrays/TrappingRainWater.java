package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
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
}
