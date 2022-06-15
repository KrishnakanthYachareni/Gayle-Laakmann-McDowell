package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> ans = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        ans.forEach(i -> System.out.println(Arrays.asList(i)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == targetSum) {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (sum > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
