/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/TSORT
 * <p>
 * Solution: max input value is 10^6 so it can be done using counting sort linear time O(n+m)
 * <p>
 * if we use other that coount sort can give O(n^2) complexity
 */
public class TurboSort {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(reader.readLine().trim());
            int[] ar = new int[(int) 1e6];
            while (n-- > 0) {
                ar[Integer.parseInt(reader.readLine())]++;
            }
            for (int i = 0; i < ar.length; i++) {
                while (ar[i] != 0) {
                    writer.write(String.valueOf(i));
                    writer.newLine();
                    ar[i]--;
                }
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
