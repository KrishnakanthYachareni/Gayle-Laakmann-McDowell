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
 * @link https://codeforces.com/problemset/problem/236/A
 */
public class BoyOrGirl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String username = reader.readLine();
        int ans = countUniqueChar(username);
        if ((ans & 1) != 1) {
            writer.write("CHAT WITH HER!");
        } else {
            writer.write("IGNORE HIM!");
        }
        writer.flush();
    }

    public static int countUniqueChar(String str) {
        boolean[] table = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            table[str.charAt(i) - 'a'] = true;
        }
        int ans = 0;
        for (boolean bool : table) {
            if (bool)
                ans++;
        }
        return ans;
    }
}
