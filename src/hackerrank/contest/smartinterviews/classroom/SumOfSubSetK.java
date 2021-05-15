package hackerrank.contest.smartinterviews.classroom;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers and Sum K check whether any subset of array sum is equals to given K or not.
 * <p>
 * TC = O(2^N), SC = O(1)
 */
public final class SumOfSubSetK {
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(5, -3, 10, 18, -5);
        boolean ans = solve(ar, 16);
        System.out.println(ans);
    }

    public static boolean solve(List<Integer> A, int B) {
        for (int i = 0; i < 1 << A.size(); i++) {
            int ans = 0;
            for (int j = 0; j < Math.log(i) + 1; j++) {
                if (checkBit(i, j)) {
                    ans += A.get(j);
                }
            }
            if (ans == B) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

}
