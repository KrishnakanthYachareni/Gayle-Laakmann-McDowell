/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class RangeOfPrimes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        int[] ans = primes((int) 1e6);
        while (t-- > 0) {
            String[] ar = reader.readLine().split(" ");
            int a = Integer.parseInt(ar[0]), b = Integer.parseInt(ar[1]);
            writer.write(String.valueOf(ans[b] - ans[a - 1]));
            writer.newLine();
            writer.flush();
        }
    }

    public static int[] primes(int n) {
        boolean p[] = new boolean[n + 1];
        Arrays.fill(p, true);
        for (int i = 2; i * i <= n; i++) {
            if (p[i]) {
                for (int j = 2 * i; j <= n; j += i)
                    p[j] = false;
            }
        }
        int ans[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1];
            if (p[i]) {
                ans[i]++;
            }
        }
        return ans;
    }
}
