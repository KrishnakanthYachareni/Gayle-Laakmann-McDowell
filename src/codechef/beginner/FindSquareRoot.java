/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.beginner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/FSQRT
 */
public class FindSquareRoot {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                int ans = findSquareRoot(n);
                writer.write(String.valueOf(ans));
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static int findSquareRoot(int n) {
        if (n == 1) {
            return 1;
        }
        int low = 1, high = n / 2, mid;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == n) {
                ans = mid;
                break;
            } else if (mid * mid < n) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
