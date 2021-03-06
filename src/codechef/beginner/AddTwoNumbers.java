/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FLOW001
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                String[] ar = reader.readLine().trim().split(" ");
                int sum = Integer.parseInt(ar[0]) + Integer.parseInt(ar[1]);
                writer.write(String.valueOf(sum));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
