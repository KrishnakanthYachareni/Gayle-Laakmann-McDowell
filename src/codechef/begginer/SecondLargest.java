/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.begginer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FLOW017
 */
public class SecondLargest {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim()), temp;
            while (t-- > 0) {
                String[] ar = reader.readLine().trim().split(" ");
                int a = Integer.parseInt(ar[0]), b = Integer.parseInt(ar[1]), c = Integer.parseInt(ar[2]);
                if (a > b) {
                    a = a + b;
                    b = a - b;
                    a = a - b;
                }
                if (a > c) {
                    a = a + c;
                    c = a - c;
                    a = a - c;
                }
                if (b > c) {
                    b = b + c;
                    c = b - c;
                    b = b - c;
                }
                writer.write(String.valueOf(b));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
