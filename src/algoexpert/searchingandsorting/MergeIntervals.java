package algoexpert.searchingandsorting;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    /*
        TC = O(n log n), SC = O(log N) or O(N) this may take during sorting of intervals
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> mergeIntervals = new LinkedList<>();

        for (int[] interval : intervals) {
            if (mergeIntervals.isEmpty() || mergeIntervals.getLast()[1] < interval[0]) {
                mergeIntervals.add(interval);
            }

            mergeIntervals.getLast()[1] = Math.max(mergeIntervals.getLast()[1], interval[1]);
        }

        return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }
}
