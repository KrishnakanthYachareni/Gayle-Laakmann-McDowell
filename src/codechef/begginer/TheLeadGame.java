/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.begginer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/TLG
 */
public class TheLeadGame {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            int p1 = 0, p2 = 0, w = 0, l = 0;
            while (t-- > 0) {
                String[] ar = reader.readLine().trim().split(" ");
                p1 += Integer.parseInt(ar[0]);
                p2 += Integer.parseInt(ar[1]);
                int ld = Math.abs(p1 - p2);
                if (w < ld) {
                    l = p1 > p2 ? 1 : 2;
                    w = ld;
                }
            }
            writer.write(String.valueOf(l + " " + w));
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
