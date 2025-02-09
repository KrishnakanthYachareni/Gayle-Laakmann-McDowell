package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {

    // Array should be sorted before
    private static List<List<Integer>> kSum(int[] array, int target, int start, int k) {
        int n = array.length;
        List<List<Integer>> quads = new ArrayList<>();

        if (start == n)
            return quads;

        if (k == 2)
            return twoSum(array, start, target);

        for (int i = start; i < n; i++) {
            for (List<Integer> pair : kSum(array, target - array[i], i + 1, k - 1)) {
                quads.add(new ArrayList<>(Arrays.asList(array[i])));
                quads.get(quads.size() - 1).addAll(pair);
            }
        }
        return quads;
    }

    private static List<List<Integer>> twoSum(int[] array, int i, int target) {
        int left = i, right = array.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum > target)
                right--;
            else if (sum < target)
                left++;
            else
                ans.add(Arrays.asList(array[left++], array[right--]));
        }
        return ans;
    }
}
