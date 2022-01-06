package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO:
public class ThreeSum {
    public static void main(String[] args) {
        int[] ar = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ar));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int c = -1 * (nums[i] + nums[j]);
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == c) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }
        return ans;
    }
}
