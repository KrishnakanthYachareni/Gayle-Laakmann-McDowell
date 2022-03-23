package leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 * <p>
 * <p>
 * Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop.
 * But wait - there is a catch. If an interviewer asks you to solve 4Sum,
 * they can follow up with 5Sum, 6Sum, and so on. What they are really expecting
 * at this point is a kSum solution.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] ar = {2, 2, 2, 2, 2};
        System.out.println(fourSum(ar, 8));

//        threeSum(ar, 8);

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 3);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (start == nums.length) { // Base condition
            return ans;
        }

        // There are k remaining values to add to the sum. The average of these values is at least (target / k).
        int averageValue = target / k;

        // We cannot obtain a sum of target if the smallest value in nums is greater than (target / k)
        // or if the largest value in nums is smaller than target / k.
        if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) {
            return ans;
        }

        if (k == 2) {
            return twoSum(nums, start, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) { // Skip duplicates check bcz Array is sorted
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    ans.add(new ArrayList<>(Collections.singletonList(nums[i])));
                    ans.get(ans.size() - 1).addAll(subset);
                }
            }
        }
        return ans;
    }

    // Using two pointer technique
    private static List<List<Integer>> twoSum(int[] nums, int i, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int l = i, h = nums.length - 1;
        while (l < h) {
            int curSum = nums[l] + nums[h];
            if (curSum < target || (l > i && nums[l] == nums[l - 1]))
                l++;
            else if (curSum > target || (h < nums.length - 1 && nums[h] == nums[h + 1]))
                h--;
            else {
                ans.add(Arrays.asList(nums[l++], nums[h--]));
            }
        }
        return ans;
    }
}
