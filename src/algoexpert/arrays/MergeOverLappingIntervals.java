package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            int s = mergedIntervals.size();
            if (mergedIntervals.isEmpty() || mergedIntervals.get(s - 1)[1] < interval[0])
                mergedIntervals.add(interval);
            else {
                mergedIntervals.get(s - 1)[1] = Math.max(mergedIntervals.get(s - 1)[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
