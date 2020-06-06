/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.hsbc;

import java.util.NavigableSet;
import java.util.TreeSet;

public class HelpJohn {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 7};
        solve(arr, 5);
    }

    static void solve(int[] arr, int N) {
        System.out.println("-1 -1");
        NavigableSet<Integer> data = new TreeSet<>();
        data.add(arr[0]);
        for (int i = 1; i < N; i++) {
            Integer floor = data.floor(arr[i]);
            Integer ceil = data.ceiling(arr[i]);
            System.out.print(null != floor ? floor : -1);
            System.out.print(" ");
            System.out.println(null != ceil ? ceil : -1);
            data.add(arr[i]);
        }
    }
}
