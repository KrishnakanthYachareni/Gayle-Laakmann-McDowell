/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Given a Binary Search Tree and a number x, find floor & ceil of x in the given BST.
 */
public class FloorAndCeilFromBST {
    static class TreeNode {
        public int data;
        public TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int x = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = insert(root, Integer.parseInt(num));
            }
            int ceil = ceil(root, x);
            int floor = floor(root, x);
            writer.write("Ceil " + ceil + ", Floor " + floor);
            writer.newLine();
            writer.flush();
        }
    }

    public static int ceil(TreeNode root, int x) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.data < x)
            return ceil(root.right, x);
        else {
            int ceil = ceil(root.left, x);
            return ceil >= x ? ceil : root.data;
        }
    }

    public static int floor(TreeNode root, int x) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.data > x)
            return floor(root.left, x);
        else {
            int floor = floor(root.right, x);
            return floor <= x ? floor : root.data;
        }
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
