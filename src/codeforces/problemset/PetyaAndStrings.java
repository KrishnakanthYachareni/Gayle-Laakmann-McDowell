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
 * @link https://codeforces.com/problemset/problem/112/A
 */
public class PetyaAndStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = reader.readLine().toLowerCase();
        String s2 = reader.readLine().toLowerCase();
        int ans = areEqual(s1, s2);
        writer.write(String.valueOf(ans));
        writer.flush();
    }

    public static int areEqual(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) < s2.charAt(i) ? -1 : 1;
            }
        }
        return 0;
    }
}
