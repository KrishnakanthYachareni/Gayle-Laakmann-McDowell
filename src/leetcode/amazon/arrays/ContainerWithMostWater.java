package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int n = height.length, ans = Integer.MIN_VALUE;
        int leftMax = 0, rightMax = n - 1;

        while (leftMax < rightMax) {
            if (height[leftMax] < height[rightMax]) {
                ans = Math.max(ans, height[leftMax] * (rightMax - leftMax));
                leftMax++;
            } else {
                ans = Math.max(ans, height[rightMax] * (rightMax - leftMax));
                rightMax--;
            }
        }
        return ans;
    }
}
