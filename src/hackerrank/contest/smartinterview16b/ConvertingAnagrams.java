/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class ConvertingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] ar = reader.readLine().split(" ");
            int ans = solve(ar[0], ar[1]);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    public static int solve(String s1, String s2) {
        int[] table = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(table[i]);
        }
        return count;
    }
}
