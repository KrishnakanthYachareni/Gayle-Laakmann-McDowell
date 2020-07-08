/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET.
 * (If two strings are identical, they are considered prefixes of each other.
 *
 * @link https://www.hackerrank.com/challenges/no-prefix-set/problem
 */
public class NoPrefixSet {
    static class Trie {
        boolean eow;
        Trie[] ar;

        Trie() {
            this.ar = new Trie[10];
            Arrays.fill(ar, null);
            this.eow = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        Trie root = new Trie();
        while (n-- > 0) {
            String w = reader.readLine().trim();
            if (!hasPrefixSet(root, w)) {
                System.out.println("BAD SET");
                System.out.println(w);
                return;
            }
        }
        System.out.println("GOOD SET");
    }

    public static boolean hasPrefixSet(Trie root, String word) {
        boolean ans = false;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.ar[idx] != null && root.ar[idx].eow)
                return false;
            if (root.ar[idx] == null) {
                root.ar[idx] = new Trie();
                ans = true;
            }
            root = root.ar[idx];
        }
        root.eow = true;
        return ans;
    }
}
