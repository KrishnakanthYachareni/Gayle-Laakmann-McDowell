/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.contest.june20b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/JUNE20B/problems/EOEO
 */
public final class TheTomAndJerryGame {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                long ts = Long.parseLong(reader.readLine());
                long ans = jerryStrength(ts);
                writer.write(String.valueOf(ans));
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            return;
        }
    }

    private static long jerryStrength(long ts) {
        while (true) {
            if ((ts & 1) == 1) { //odd
                return ts / 2;
            } else {
                ts = ts / 2;
                if ((ts & 1) == 1) {
                    return ts / 2;
                }
            }
        }
    }
}
