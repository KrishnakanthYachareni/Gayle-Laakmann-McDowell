/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FLOW006
 */
public class SumOfDigits {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                writer.write(String.valueOf(sumOfDigits(n)));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static int sumOfDigits(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
