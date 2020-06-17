/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.begginer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FLOW018
 */
public class SmallFactorialFLOW018 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine().trim());
                if (n == 0) {
                    writer.write("1");
                } else {
                    writer.write(String.valueOf(factorial(n)));
                }
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
