/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/LUCKFOUR
 */
public class LuckyFour {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                int c = 0;
                while (n != 0) {
                    if (n % 10 == 4)
                        c++;
                    n /= 10;
                }
                writer.write(String.valueOf(c));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
