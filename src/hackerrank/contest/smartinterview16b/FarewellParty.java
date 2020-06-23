/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FarewellParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Integer> a = new ArrayList<>();
            List<Integer> d = new ArrayList<>();
            while (n-- > 0) {
                String[] ar = reader.readLine().trim().split(" ");
                a.add(Integer.valueOf(ar[0]));
                d.add(Integer.valueOf(ar[1]));
            }
            Collections.sort(a);
            Collections.sort(d);
            int ans = findRooms(a, d);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    public static int findRooms(List<Integer> a, List<Integer> d) {
        int active = 0, i = 0, j = 0, maxRooms = 0;
        while (i < a.size() && j < a.size()) {
            if (a.get(i) <= d.get(j)) {
                i++;
                active++;
                maxRooms = Math.max(maxRooms, active);
            } else {
                j++;
                active--;
            }
        }
        return maxRooms;
    }
}
