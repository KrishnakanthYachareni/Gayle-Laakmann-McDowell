package leetcode.facebook.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] ar = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(ar);
    }

    public static int[][] merge(int[][] intervals) {
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int s = ans.size();
            if (ans.isEmpty() || ans.get(s - 1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(s - 1)[1] = Math.max(ans.get(s - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
