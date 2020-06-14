/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.begginer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @link https://www.codechef.com/problems/FCTRL2
 * <p>
 * Important
 * <p>
 * Reference: https://blog.codechef.com/2009/07/02/tutorial-for-small-factorials/
 */
public class SmallFactorials {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            int[] ar = new int[200];
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                Arrays.fill(ar, 1);
                int end = 0, carry = 0;
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j <= end; j++) {
                        ar[j] = ar[j] * i + carry;
                        carry = ar[j] / 10;
                        ar[j] = ar[j] % 10;
                    }
                    while (carry != 0) {
                        end++;
                        ar[end] = carry % 10;
                        carry /= 10;
                    }
                }
                for (int i = end; i >= 0; i--) {
                    writer.write(String.valueOf(ar[i]));
                }
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
