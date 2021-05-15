package hackerrank.bits;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 * <p>
 * TC = O(n), SC = O(1)
 * <p>
 * Problem: https://www.hackerrank.com/challenges/lonely-integer/problem
 */
public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        int ans = lonelyinteger(in);
        System.out.println(ans);
    }

    public static int lonelyinteger(List<Integer> a) {
        int ans = 0;
        for (int ele : a) {
            ans ^= ele;
        }
        return ans;
    }
}
