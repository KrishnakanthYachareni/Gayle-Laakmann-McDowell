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
 * @link https://codeforces.com/problemset/problem/281/A
 */
public class WordCapitalization {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = reader.readLine().trim();
        if (word.charAt(0) >= 97) {
            writer.write(String.valueOf((char) (word.charAt(0) - 32)));
            writer.write(word.substring(1, word.length()));
        } else {
            writer.write(word);
        }
        writer.flush();
    }
}
