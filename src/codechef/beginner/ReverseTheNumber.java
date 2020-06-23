/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FLOW007
 */
public class ReverseTheNumber {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                int rev = 0;
                while (n != 0) {
                    rev = rev + n % 10;
                    rev *= 10;
                    n /= 10;
                }
                writer.write(String.valueOf(rev / 10));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
