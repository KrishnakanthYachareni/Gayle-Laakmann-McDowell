/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * Example:
 * <p>
 * Given [1,2,0] return 3,
 * <p>
 * [3,4,-1,1] return 2,
 * <p>
 * [-8, -7, -6] returns 1
 * <p>
 * Your algorithm should run in O(n) time and use constant space.
 *
 * @link https://www.interviewbit.com/problems/first-missing-integer/
 * <p>
 * Complexity: O(n), O(1)
 */
public final class FirstMissingNumber {

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(-8); //-8, -7, -6
        li.add(-7);
        li.add(-6);
        int ans = missingNumber(li);
        System.out.println(ans);
    }

    public static int missingNumber(ArrayList<Integer> A) {
        int n = A.size();
        int bigNumber = n + 100;
        int i;
        for (i = 0; i < n; i++) {
            if (A.get(i) <= 0 || A.get(i) > n) {
                A.set(i, bigNumber);
            }
        }

        for (i = 0; i < n; i++) {
            int val = Math.abs(A.get(i));
            if (val != bigNumber && A.get(val - 1) > 0) {
                A.set(val - 1, -1 * A.get(val - 1));
            }
        }

        for (i = 0; i < n; i++) {
            if (A.get(i) > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
