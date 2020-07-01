/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of unique elements, construct a Binary Search Tree and print the right-view of the tree.
 * Right view of a Tree is the set of nodes visible when tree is viewed from right side.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-right-view-of-tree
 */
public class RightViewOfTree {
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
                root = insert(root, Integer.parseInt(num));
            }
//            RightView(root);
            maxLevel = 0;
            rightViewRec(root, 1);
            System.out.println();
        }
    }

    // Recursive
    static int maxLevel;

    public static void rightViewRec(TreeNode root, int l) {
        if (root == null)
            return;
        if (maxLevel < l) {
            System.out.print(root.data + " ");
            maxLevel = l;
        }
        rightViewRec(root.right, l + 1);
        rightViewRec(root.left, l + 1);
    }

    // Iterative
    public static void RightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int temp = 0;
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) {
                temp = root.data;
                if (root.left != null)
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            } else {
                if (!q.isEmpty()) {
                    System.out.print(temp + " ");
                    q.add(null);
                }
            }
        }
        System.out.print(temp);
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
