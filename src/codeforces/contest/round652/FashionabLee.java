/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.contest.round652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://codeforces.com/contest/1369/problem/A
 */
public class FashionabLee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            writer.write(n % 4 == 0 ? "YES" : "NO");
            writer.newLine();
        }
        writer.flush();
    }
}
