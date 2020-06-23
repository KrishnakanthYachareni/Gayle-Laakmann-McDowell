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
import java.util.TreeSet;

public class RangeSumSubArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] ar = reader.readLine().split(" ");
            int n = Integer.parseInt(ar[0]), a = Integer.parseInt(ar[1]), b = Integer.parseInt(ar[2]);
            int[] in = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ans = rangeSum(in, n, a, b);
            writer.write(String.valueOf(ans));
            writer.newLine();
        }
        writer.flush();
    }

    public static int rangeSum(int[] ar, int n, int a, int b) {
        TreeSet<PrefixSumPair> set = new TreeSet<>();
        PrefixSumPair[] s = new PrefixSumPair[n + 1];
        s[0] = new PrefixSumPair(0, 0);
        for (int i = 1; i < s.length; i++) {
            s[i] = new PrefixSumPair(s[i - 1].data + ar[i - 1], i);
        }
        int ans = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            PrefixSumPair sum = s[i];
            PrefixSumPair low = new PrefixSumPair(a + sum.data, -1);
            PrefixSumPair high = new PrefixSumPair(b + sum.data, s.length);
            ans += set.subSet(low, high).size();
            set.add(sum);
        }
        return ans;
    }

    static class PrefixSumPair implements Comparable<PrefixSumPair> {
        long data;
        int idx;

        PrefixSumPair(long data, int idx) {
            this.data = data;
            this.idx = idx;
        }

        @Override
        public int compareTo(PrefixSumPair other) {
            if (this.data == other.data) {
                return this.idx - other.idx;
            }
            return Long.compare(this.data, other.data);
        }
    }
}
