/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of unique elements, construct a Binary Search Tree. Now, given two nodes u and v of the BST, find their Lowest Common Ancestor (LCA).
 * LCA is defined as the furthest node from the root that is an ancestor for both u and v.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-least-common-ancestor
 */
public class LeastCommonAncestor {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            String[] ar = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(ar[0]), q = Integer.parseInt(ar[1]);
            String[] ele = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String str : ele) {
                root = insert(root, Integer.parseInt(str));
            }
            while (q-- > 0) {
                String[] queries = reader.readLine().trim().split(" ");
                TreeNode ans = lca(root, Integer.parseInt(queries[0]), Integer.parseInt(queries[1]));
                System.out.print(ans.data + " ");
            }
            System.out.println();
        }
    }

    public static TreeNode lca(TreeNode root, int u, int v) {
        if (u < root.data && v < root.data)
            return lca(root.left, u, v);
        else if (u > root.data && v > root.data)
            return lca(root.right, u, v);
        else
            return root;
    }

    private static TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }
}
