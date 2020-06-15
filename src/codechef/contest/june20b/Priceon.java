/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.contest.june20b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/JUNE20B/problems/PRICECON
 */
public final class Priceon {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                int k = Integer.parseInt(reader.readLine().split(" ")[1]);
                String[] prices = reader.readLine().split(" ");
                int ans = ceilPrices(prices, k);
                writer.write(String.valueOf(ans));
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            return;
        }
    }

    public static int ceilPrices(String[] prices, int k) {
        int p, sum = 0;
        for (String price : prices) {
            p = Integer.parseInt(price);
            if (p > k) {
                sum += (p - k);
            }
        }
        return sum;
    }
}
