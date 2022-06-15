package algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    // SC = O(N), TC = O(N)
    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        int longestRangeLength = 0;
        int[] longestRange = new int[2];

        Arrays.stream(array).forEach(i -> map.put(i, true));

        for (int num : array) {
            if (!map.get(num))
                continue;
            int left = num - 1, right = num + 1;
            int currentLength = 1;

            map.put(num, false); // current element
            while (map.containsKey(left) && map.get(left)) {
                map.put(left, false);
                currentLength++;
                left--;
            }

            while (map.containsKey(right) && map.get(right)) {
                map.put(right, false);
                currentLength++;
                right++;
            }

            if (currentLength > longestRangeLength) {
                longestRangeLength = currentLength;
                longestRange = new int[]{left + 1, right - 1};
            }
        }
        return longestRange;
    }
}
