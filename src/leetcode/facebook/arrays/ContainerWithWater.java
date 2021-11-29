package leetcode.facebook.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithWater {
    public static void main(String[] args) {

    }

    /*
    // Brute force Time = O(n^2)
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int min = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, min * (j - i));
            }
        }
        return maxArea;
    }*/

    /**
     * The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.
     * <p>
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
     * Further, we maintain a variable maxarea to store the maximum area obtained till now.
     * At every step, we find out the area formed between them, update maxarea and move the pointer pointing to the shorter
     * line towards the other end by one step.
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0, p1 = 0, p2 = n - 1, min;
        while (p1 < p2) {
            min = Math.min(height[p1], height[p2]);
            maxArea = Math.max(maxArea, min * (p2 - p1));
            if (height[p1] < height[p2])
                p1++;
            else
                p2--;
        }
        return maxArea;
    }
}
