/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.problemset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NextRound {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]), k = Integer.parseInt(firstLine[1]);
        int[] players = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = advancers(players, n, k);
        writer.write(String.valueOf(ans));
        writer.flush();
    }

    public static int advancers(int[] players, int n, int k) {
        int kthValue = players[k - 1], ans = 0;
        for (int i = 0; i < n; i++) {
            if (players[i] >= kthValue && players[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
}
