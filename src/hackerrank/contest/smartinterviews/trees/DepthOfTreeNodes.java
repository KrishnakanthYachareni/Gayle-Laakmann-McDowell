/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of unique elements, construct a Binary Search Tree and for every node, print the depth of that node.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-depth-of-tree-nodes
 */
public class DepthOfTreeNodes {
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
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = insertAndDepth(root, Integer.parseInt(num), 0);
            }
            System.out.println();
        }
    }

    public static TreeNode insertAndDepth(TreeNode root, int x, int l) {
        if (root == null) {
            System.out.print(l + " ");
            return new TreeNode(x);
        }
        if (x < root.data) {
            root.left = insertAndDepth(root.left, x, l + 1);
        } else {
            root.right = insertAndDepth(root.right, x, l + 1);
        }
        return root;
    }
}
