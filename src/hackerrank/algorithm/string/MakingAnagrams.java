/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.algorithm.string;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @link https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = "cde";
        String b = "abc";
        int ans = solve(a, b);
        writer.write(String.valueOf(ans));
        writer.flush();
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
