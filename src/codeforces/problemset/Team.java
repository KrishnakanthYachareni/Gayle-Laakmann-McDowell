/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.problemset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://codeforces.com/problemset/problem/231/A
 */
public class Team {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        int ans = 0;
        while (t-- > 0) {
            String[] contests = reader.readLine().split(" ");
            int c = 0;
            for (String contest : contests) {
                if (contest.equals("1")) {
                    c++;
                }
                if (c == 2) {
                    ans++;
                    break;
                }
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }

}
