/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LightMan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] ar = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(ar[0]), m = Integer.parseInt(ar[1]);
            String[] lights = reader.readLine().trim().split(" ");
            int ans = spells(lights, n, m);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    public static int spells(String[] ar, int n, int m) {
        int l = 0, c = 0, seriesOfLights = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i].equals("0")) {
                c++;
            }
            while (c > m) {
                if (ar[l].equals("0")) {
                    c--;
                }
                l++;
            }
            if (i - l + 1 > seriesOfLights) {
                seriesOfLights = i - l + 1;
            }
        }
        return seriesOfLights;
    }
}
