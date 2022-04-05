package leetcode.amazon.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 7, 2, 8,};
        lengthOfLIS(arr);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        /*//find the index of max number in dp table
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        int i = maxIndex;
        while (i-- > 0) {
            if (dp[i] == dp[maxIndex] - 1) {
                System.out.print(nums[maxIndex] + ",");
                maxIndex = i;
            }
        }*/
        return Arrays.stream(dp).max().getAsInt();
    }


    public static void findLIS(int[] ar) {
        if (ar == null || ar.length == 0) {
            return;
        }
        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            LIS.add(new ArrayList<>());
        }
        LIS.get(0).add(ar[0]);

        for (int i = 1; i < ar.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(ar[i]);
        }
        int j = 0;
        for (int i = 0; i < ar.length; i++) {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }
        System.out.print(LIS.get(j));
    }
}
