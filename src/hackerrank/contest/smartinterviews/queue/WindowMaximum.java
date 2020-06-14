/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-window-maximum
 */
public class WindowMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int[] sizeAndK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ar = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ans = windowMax(ar, sizeAndK[0], sizeAndK[1]);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    private static int windowMax(int[] ar, int n, int k) {
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(ar[i]))
                map.put(ar[i], map.get(ar[i]) + 1);
            else
                map.put(ar[i], 1);
        }
        int ans = map.lastKey();
        int i = 0, j = k;
        while (i < n && j < n) {
            // Add Incoming element to window
            if (map.containsKey(ar[j]))
                map.put(ar[j], map.get(ar[j]) + 1);
            else
                map.put(ar[j], 1);

            // Remove outgoing going element from window
            if (map.get(ar[i]) > 1)
                map.put(ar[i], map.get(ar[i]) - 1);
            else
                map.remove(ar[i]);
            ans += map.lastKey();
            i++;
            j++;
        }
        return ans;
    }
}
