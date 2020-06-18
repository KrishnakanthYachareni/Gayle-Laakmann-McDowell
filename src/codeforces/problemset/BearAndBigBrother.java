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
 * @link https://codeforces.com/problemset/problem/791/A
 */
public class BearAndBigBrother {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().trim().split(" ");
        int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
        int ans = 0;
        while (a <= b) {
            ans++;
            a = 3 * a;
            b = 2 * b;
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
