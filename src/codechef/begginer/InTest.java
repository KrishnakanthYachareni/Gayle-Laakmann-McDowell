/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.begginer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/problems/INTEST
 */
public class InTest {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] a = reader.readLine().split(" ");
            int n = Integer.parseInt(a[0]), k = Integer.parseInt(a[1]);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (Integer.parseInt(reader.readLine()) % k == 0) {
                    ans++;
                }
            }
            writer.write(String.valueOf(ans));
            writer.flush();
        } catch (Exception e) {
            return;
        }
    }
}
