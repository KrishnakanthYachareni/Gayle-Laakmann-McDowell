package leetcode.amazon;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] ar = {-1, 2, 1, -4};
        int ans = threeSumClosest(ar, 1);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, diff = Integer.MAX_VALUE;

        // OR we can put "diff != 0" in for loop cond, when sum of pair is equals to given target.
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, h = n - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                // OR we can remove from here and we can put "diff != 0" in for loop cond, when sum of pair is equals to given target.
                if (sum == target)
                    return target;
                else if (sum > target)
                    h--;
                else
                    l++;
            }
        }
        return target - diff;
    }
}
