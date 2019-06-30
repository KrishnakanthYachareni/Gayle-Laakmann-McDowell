/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.hsbc;

public class SamHeight {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1};
        System.out.println(solve(arr, 2));
    }

    static int solve(int[] arr, int s) {
        int leftCount = 0, rightCount = 0;
        for (int a : arr) {
            if (a < s) {
                leftCount++;
            }
            if (a > s) {
                rightCount++;
            }
        }
        if (leftCount == rightCount) {
            return -1;
        }
        return Math.abs(leftCount - rightCount);
    }
}
