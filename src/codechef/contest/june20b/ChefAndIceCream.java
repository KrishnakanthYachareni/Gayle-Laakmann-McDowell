/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.contest.june20b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/JUNE20B/problems/CHFICRM
 */
public final class ChefAndIceCream {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                String[] ar = reader.readLine().split(" ");
                boolean ans = sell(ar, n);
                writer.write(ans ? "YES" : "NO");
                writer.newLine();
                writer.flush();
            }
        } catch (
                Exception e) {
            return;
        }
    }

    public static boolean sell(String[] arr, int n) {
        int fiveCoin = 0, tenCoin = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("5")) {
                fiveCoin++;
            } else if (arr[i].equals("10")) {
                if (fiveCoin > 0) {
                    fiveCoin--;
                    tenCoin++;
                } else {
                    return false;
                }
            } else {
                if (tenCoin > 0) {
                    tenCoin--;
                } else if (fiveCoin >= 2) {
                    fiveCoin = fiveCoin - 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
