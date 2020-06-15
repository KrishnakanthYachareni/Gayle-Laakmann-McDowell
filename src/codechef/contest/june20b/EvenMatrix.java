/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codechef.contest.june20b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.codechef.com/JUNE20B/problems/EVENM
 */
public final class EvenMatrix {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                int counter = 1;
                for (int i = 1; i <= n; i++) {
                    if ((i & 1) == 1) { // odd
                        for (int j = 1; j <= n; j++) {
                            writer.write(counter + " ");
                            counter++;
                        }
                    } else { // even
                        counter += n - 1;
                        for (int j = 1; j <= n; j++) {
                            writer.write(counter + " ");
                            counter--;
                        }
                        counter += n + 1;
                    }
                    writer.newLine();
                    writer.flush();
                }
            }
        } catch (
                Exception e) {
            return;
        }
    }
}
