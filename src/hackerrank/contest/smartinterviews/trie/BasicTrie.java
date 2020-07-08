/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BasicTrie {
    static class Trie {
        int cnt;
        Trie[] ar;

        Trie() {
            this.ar = new Trie[26];
            Arrays.fill(ar, null);
            this.cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        Trie root = new Trie();
        while (n-- > 0) {
            insert(root, reader.readLine().trim());
        }
        int q = Integer.parseInt(reader.readLine().trim());
        while (q-- > 0) {
            String query = reader.readLine().trim();
            int ans = solve(root, query);
            System.out.println(ans);
        }
    }

    static int solve(Trie root, String query) {
        for (int i = 0; i < query.length(); i++) {
            int idx = query.charAt(i) - 'a';
            if (root.ar[idx] == null)
                return 0;
            root = root.ar[idx];
        }
        return root.cnt;
    }

    static void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.ar[idx] == null)
                root.ar[idx] = new Trie();
            root.ar[idx].cnt++;
            root = root.ar[idx];
        }
    }
}
