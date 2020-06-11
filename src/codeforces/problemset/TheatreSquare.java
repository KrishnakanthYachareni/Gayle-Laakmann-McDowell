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
 * http://codeforces.com/problemset/problem/1/A
 */
public class TheatreSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sides = reader.readLine().split(" ");
        long n = Long.parseLong(sides[0]);
        long m = Long.parseLong(sides[1]);
        long a = Long.parseLong(sides[2]);
        // The sides of flagstones should be parallel to the sides of the Square
        long l = n / a, w = m / a;
        if (n % a != 0) l++;
        if (m % a != 0) w++;
        writer.write(String.valueOf(l * w));
        writer.flush();
    }
}
