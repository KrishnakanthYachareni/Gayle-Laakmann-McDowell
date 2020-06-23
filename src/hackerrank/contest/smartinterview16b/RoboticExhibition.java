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

public class RoboticExhibition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] ar = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ar);
            int ans = minStrength(ar, n);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    private static int minStrength(int[] ar, int n) {
        int ans = 1, i = 0;
        while (i < n && ar[i] <= ans) {
            ans = ans + ar[i];
            i++;
        }
        return ans;
    }
}
