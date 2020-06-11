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
 * @link https://codeforces.com/problemset/problem/50/A
 */
public class DominoPiling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ar = reader.readLine().split(" ");
        int n = Integer.parseInt(ar[0]), m = Integer.parseInt(ar[1]);
        int ans = (n * m) / 2;
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
