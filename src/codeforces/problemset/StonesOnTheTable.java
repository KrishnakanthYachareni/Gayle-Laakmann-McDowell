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
 * @link https://codeforces.com/problemset/problem/266/A
 */
public class StonesOnTheTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String stones = reader.readLine();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (stones.charAt(i - 1) == stones.charAt(i)) {
                ans++;
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
