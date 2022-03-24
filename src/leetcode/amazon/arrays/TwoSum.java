package leetcode.amazon.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * Link: https://leetcode.com/problems/two-sum/
 * <p>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] ans = twoSum(nums, 6);
        System.out.println(ans[0] + " " + ans[1]);
    }

    /**
     * One-pass Hash Table
     * While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     * <p>
     * TC = O(n), SC = O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[]{i, map.get(sum)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * Strategy: is
     * 1. First create an another array with the given array element indexes then sort the both the arrays according to array element values using merge sort.
     * 2. On sorted array apply two pointer technique to find out the pair equals to given target and with the same positions return the pair indexes from index array.
     * <p>
     * TC = O(nlogn + n), SC = O(n+n)
     */
    public static int[] Solution2(int[] nums, int target) {
        int len = nums.length;
        int[] pos = getPositionArray(len);
        mergeSort(nums, 0, len - 1, pos);
        //Apply two pointer solution
        int p1 = 0, p2 = len - 1;
        int sum = 0;
        while (p1 < len && p2 >= 0) {
            sum = nums[p1] + nums[p2];
            if (sum == target) {
                break;
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return new int[]{pos[p1], pos[p2]};
    }

    private static void mergeSort(int[] nums, int low, int high, int[] pos) {
        if (low == high) {
            return;
        }
        int m = (low + high) / 2;
        mergeSort(nums, low, m, pos);
        mergeSort(nums, m + 1, high, pos);
        merge(nums, low, m, high, pos);
    }

    private static void merge(int[] nums, int low, int m, int high, int[] pos) {
        int p1 = low, p2 = m + 1, idx = 0;
        int[] temp = new int[high - low + 1];
        int[] temp2 = new int[high - low + 1];
        while (p1 <= m && p2 <= high) {
            if (nums[p1] < nums[p2]) {
                temp[idx] = nums[p1];
                temp2[idx] = pos[p1];
                idx++;
                p1++;
            } else {
                temp[idx] = nums[p2];
                temp2[idx] = pos[p2];
                idx++;
                p2++;
            }
        }
        while (p1 <= m) {
            temp[idx] = nums[p1];
            temp2[idx] = pos[p1];
            idx++;
            p1++;
        }
        while (p2 <= high) {
            temp[idx] = nums[p2];
            temp2[idx] = pos[p2];
            idx++;
            p2++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
            pos[i] = temp2[i - low];
        }
    }

    private static int[] getPositionArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
