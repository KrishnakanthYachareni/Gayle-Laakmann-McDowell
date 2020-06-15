/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.contest.june20b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/JUNE20B/problems/XYSTR
 */
public final class ChefAndString {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                String str = reader.readLine();
                int ans = dancePairs(str);
                writer.write(String.valueOf(ans));
                writer.newLine();
                writer.flush();
            }
        } catch (
                Exception e) {
            return;
        }
    }

    public static int dancePairs(String str) {
        int i = 0, j = 2, ans = 0, n = str.length();
        while (i < n && j <= n) {
            String pair = str.substring(i, j);
            if ("xy".equals(pair) || "yx".equals(pair)) {
                ans++;
                i += 2;
                j += 2;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }
}
