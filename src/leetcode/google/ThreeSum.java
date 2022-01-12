package leetcode.google;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] ar = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ar));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumII(nums, i, ans);
            }
        }
        return ans;
    }


    // Using two pointer technique
    private static void twoSumII(int[] nums, int i, List<List<Integer>> ans) {
        int l = i + 1, h = nums.length - 1;
        while (l < h) {
            int sum = nums[l] + nums[h] + nums[i];
            if (sum < 0)
                l++;
            else if (sum > 0)
                h--;
            else {
                ans.add(Arrays.asList(nums[i], nums[l++], nums[h--]));
                // skip duplicates
                while (l < h && nums[l] == nums[l - 1])
                    l++;
            }
        }
    }

    // Using HashTable concept
    void twoSumIISet(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }
}
