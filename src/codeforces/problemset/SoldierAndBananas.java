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
 * @link https://codeforces.com/problemset/problem/546/A
 */
public class SoldierAndBananas {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ar = reader.readLine().split(" ");
        int k = Integer.parseInt(ar[0]);
        int n = Integer.parseInt(ar[1]);
        int w = Integer.parseInt(ar[2]);
        int ans = 0;
        for (int i = 1; w > 0; i++) {
            ans += i * k;
            w--;
        }
        if (ans >= n)
            writer.write(String.valueOf(ans - n));
        else
            writer.write("0");
        writer.flush();
    }
}
