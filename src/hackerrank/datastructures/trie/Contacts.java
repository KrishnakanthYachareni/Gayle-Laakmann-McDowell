/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solving this problem using Trie data stricture
 *
 * @link https://www.hackerrank.com/challenges/contacts/problem
 */
public class Contacts {
    static class Trie {
        int cnt;
        Trie[] ar;

        Trie() {
            this.ar = new Trie[26];
            Arrays.fill(ar, null);
            this.cnt = 0;
        }
    }

    static List<Integer> contacts(String[][] queries) {
        List<Integer> li = new ArrayList<>();
        Trie root = new Trie();
        for (String[] ar : queries) {
            if ("add".equals(ar[0])) {
                insert(root, ar[1]);
            } else {
                li.add(solve(root, ar[1]));
            }
        }
        return li;
    }

    private static void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.ar[idx] == null)
                root.ar[idx] = new Trie();
            root.ar[idx].cnt++;
            root = root.ar[idx];
        }
    }

    private static int solve(Trie root, String query) {
        for (int i = 0; i < query.length(); i++) {
            int idx = query.charAt(i) - 'a';
            if (root.ar[idx] == null)
                return 0;
            root = root.ar[idx];
        }
        return root.cnt;
    }
}
