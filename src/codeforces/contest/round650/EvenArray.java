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
 * @link https://codeforces.com/contest/1367/problem/B
 */
public class EvenArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] ar = reader.readLine().split(" ");
            int e = 0, o = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (Integer.parseInt(ar[i]) % 2 != 0) {
                        e++;
                    }
                } else {
                    if (Integer.parseInt(ar[i]) % 2 == 0) {
                        o++;
                    }
                }
            }
            if (e != o) {
                writer.write("-1");
            } else {
                writer.write(String.valueOf(e));
            }
            writer.newLine();
            writer.flush();
        }
    }
}
