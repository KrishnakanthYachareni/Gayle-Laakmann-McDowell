/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array of positive integers, find 2 elements such that their xor: a ^ b is maximum.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-maximum-xor
 */
public class MaximumXOR {
    static class Trie {
        Trie[] ar;

        Trie() {
            ar = new Trie[2];
            Arrays.fill(ar, null);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] ar = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 0;
            for (int item : ar) {
                max = Math.max(max, item);
            }
            int bits = 31;
            Trie root = new Trie();
            for (int i = 0; i < n; i++) {
                insert(root, ar[i], bits);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, solve(root, ar[i], bits));
            }
            System.out.println(ans);
        }
    }

    private static int solve(Trie root, int x, int bits) {
        int b, ans = 0;
        for (int i = bits; i >= 0; i--) {
            b = checkBit(x, i) ? 1 : 0;
            if (root.ar[1 - b] != null) {
                ans += (1 << i);
                root = root.ar[1 - b];
            } else {
                root = root.ar[b];
            }
        }
        return ans;
    }

    private static void insert(Trie root, int x, int bits) {
        int b;
        for (int i = bits; i >= 0; i--) {
            b = checkBit(x, i) ? 1 : 0;
            if (root.ar[b] == null)
                root.ar[b] = new Trie();
            root = root.ar[b];
        }
    }

    private static boolean checkBit(int x, int i) {
        return (x & (1 << i)) != 0;
    }
}
