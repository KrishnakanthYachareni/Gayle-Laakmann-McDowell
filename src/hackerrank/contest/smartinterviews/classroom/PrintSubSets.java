package hackerrank.contest.smartinterviews.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers print all the subsets of a given set using bitwise operators.
 * <p>
 * TC = O(2^N), SC = O(1)
 */
public final class PrintSubSets {
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1, 2, 3);
        solve(ar);
    }

    public static void solve(List<Integer> a) {
        for (int i = 0; i < 1 << a.size(); i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < Math.log(i) + 1; j++) {
                if (checkBit(i, j)) {
                    set.add(a.get(j));
                }
            }
            System.out.println(set);
        }
    }

    private static boolean checkBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

}
