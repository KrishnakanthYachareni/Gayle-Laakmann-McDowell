/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.problemset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class HelpfulMaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sum = reader.readLine().split("\\+");
        Arrays.sort(sum);
        for (int i = 0; i < sum.length - 1; i++) {
            writer.write(sum[i] + "+");
        }
        writer.write(sum[sum.length - 1]);
        writer.flush();
    }
}
