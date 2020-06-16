/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.contest.round650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://codeforces.com/contest/1367/problem/A
 */
public final class ShortSubstrings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String str = reader.readLine();
            writer.write(str.substring(0, 2));
            for (int i = 2; i < str.length() - 1; i += 2) {
                writer.write(String.valueOf(str.charAt(i + 1)));
                writer.flush();
            }
            writer.newLine();
        }
        writer.flush();
    }
}
