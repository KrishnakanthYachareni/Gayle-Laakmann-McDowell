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
 * @link https://codeforces.com/problemset/problem/977/A
 */
public class WrongSubtraction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]);
        while (k-- > 0) {
            if (n % 10 == 0) {
                n /= 10;
            } else {
                n--;
            }
        }
        writer.write(String.valueOf(n));
        writer.flush();
    }
}
