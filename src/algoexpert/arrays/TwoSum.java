package algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int r = targetSum - array[i];
            if (map.containsKey(r) && map.get(r) != i) {
                return new int[]{r, array[i]};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[0];
    }
}
