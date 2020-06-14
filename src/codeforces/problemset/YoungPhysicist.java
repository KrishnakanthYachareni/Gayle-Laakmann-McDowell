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
 * @link https://codeforces.com/problemset/problem/69/A
 */
public class YoungPhysicist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = 0;
        int y = 0;
        int z = 0;
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] str = reader.readLine().split(" ");
            x += Integer.parseInt(str[0]);
            y += Integer.parseInt(str[1]);
            z += Integer.parseInt(str[2]);
        }
        if (x == 0 && y == 0 && z == 0) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }
        writer.flush();
    }
}
