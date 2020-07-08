/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//TODO: Read input as complete binary tree.
public class IsBST {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[] ar = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean ans = inorder(ar, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println(ans);
        }
    }

    public static boolean inorder(int[] ar, int idx, int a, int b) {
        if (idx > ar.length) {
            return true;
        }
        return (ar[idx] > a && ar[idx] < b)
                && inorder(ar, getLeftChild(ar, idx), a, ar[idx])
                && inorder(ar, getRightChild(ar, idx), ar[idx], b);
    }

    public static int getRightChild(int[] ar, int index) {
        if ((2 * index) + 1 < ar.length)
            return (2 * index) + 1;
        return -1;
    }

    public static int getLeftChild(int[] ar, int index) {
        if (2 * index < ar.length)
            return 2 * index;
        return -1;
    }
}
