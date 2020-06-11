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
 * @link https://codeforces.com/problemset/problem/282/A
 */
public class BitPlusPlus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        int ans = 0;
        while (t-- > 0) {
            String str = reader.readLine().trim();
            if ("X++".equals(str) || "++X".equals(str)) {
                ans++;
            } else {
                ans--;
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
