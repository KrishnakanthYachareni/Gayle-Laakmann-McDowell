/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameOfSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] ans = solve((int) 1e5);
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            if (ans[n]) {
                writer.write("Win");
            } else {
                writer.write("Lose");
            }
            writer.newLine();
            writer.flush();
        }
    }

    public static boolean[] solve(int n) {
        boolean[] ans = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!ans[i - j * j]) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans;
    }
}
