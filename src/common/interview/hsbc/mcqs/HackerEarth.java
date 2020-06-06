/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.hsbc.mcqs;

import java.util.ArrayList;

/*
7
8
9
11
8
 */
public class HackerEarth {
    public static void main(String args[]) {
        ArrayList<Integer> hack = new ArrayList<Integer>();
        hack.add(7);
        hack.add(8);
        hack.add(9);
        hack.add(11);
        hack.forEach(a -> System.out.println(a));
        hack.forEach(a -> {
            if (a % 2 == 0) System.out.println(a);
        });
    }
}
