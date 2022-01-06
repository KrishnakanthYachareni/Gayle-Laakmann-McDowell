package leetcode.google;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithWater {
    public static void main(String[] args) {
        int[] ar = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = maxArea(ar);
        System.out.println(ans);
    }

    public static int maxArea(int[] height) {
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
