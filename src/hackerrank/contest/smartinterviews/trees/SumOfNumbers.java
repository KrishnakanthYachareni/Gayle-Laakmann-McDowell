/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of unique elements, construct a Binary Search Tree and print the sum of all the numbers formed along the path from the root node to the leaf nodes.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-numbers-from-root-to-leaf-paths
 */
public class SumOfNumbers {
    static class TreeNode {
        public int data;
        public TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static long p = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = insert(root, Integer.parseInt(num));
            }
            long ans = sum(root, 0);
            System.out.println(ans);
        }
    }

    public static long sum(TreeNode root, long val) {
        if (root == null)
            return 0;
        long v = (long) Math.pow(10, digits(root));
        val = ((((val % p) * (v % p)) % p) % p + (root.data) % p) % p;
        if (isLeafNode(root))
            return val;
        return (sum(root.left, val) % p + sum(root.right, val) % p) % p;
    }

    private static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static int digits(TreeNode node) {
        return String.valueOf(node.data).length();
    }


    public static TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }
}
