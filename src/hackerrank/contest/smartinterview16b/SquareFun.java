/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SquareFun {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] ar = reader.readLine().split(" ");
            long a = Long.parseLong(ar[0]), b = Long.parseLong(ar[1]);
            long ans = (long) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }
}
