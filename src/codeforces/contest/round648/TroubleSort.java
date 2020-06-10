/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.contest.round648;

import java.util.Scanner;

/**
 * @link https://codeforces.com/contest/1365/problem/B
 * <p>
 * Solution: Read the question carefully, any two elements of different types can swap positions without having to be
 * adjacent. Therefore, it is not necessary to keep the internal order in each type, only need to exist two types to
 * achieve exchange.
 */
public final class TroubleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        while (t-- > 0) {
            n = sc.nextInt();
            int[] ar = new int[n];
            int[] br = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            int ones = 0, zeros = 0;
            for (int i = 0; i < n; i++) {
                br[i] = sc.nextInt();
                if (br[i] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (zeros == n || ones == n) {
                boolean ans = isAlreadySorted(ar, n);
                System.out.println(ans ? "Yes" : "No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean isAlreadySorted(int[] ar, int n) {
        for (int i = 1; i < n; i++) {
            if (ar[i] < ar[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
