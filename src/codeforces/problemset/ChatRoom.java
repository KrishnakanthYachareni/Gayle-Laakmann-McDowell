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
 * @link https://codeforces.com/problemset/problem/58/A
 */
public class ChatRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        String h = "hello";
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (idx == h.length()) {
                break;
            }
            if (h.charAt(idx) == str.charAt(i)) {
                idx++;
            }
        }
        writer.write(idx == h.length() ? "YES" : "NO");
        writer.flush();
    }
}
