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
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-is-complete-binary-tree
 * <p>
 * Solution:
 * A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one, which is filled from the left.
 * <p>
 * A complete binary tree has an interesting property that we can use to find the children and parents of any node.
 * <p>
 * If the index of any element in the array is i, the element in the index 2i+1 will become the left child and element in 2i+2 index will become the right child.
 * Also, the parent of any element at index i is given by the lower bound of (i-1)/2.
 */
public class IsCompleteBinaryTree {
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
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = insert(root, Integer.parseInt(num));
            }
            boolean ans = isCBT(root, 0, totalNodes(root));
            writer.write(ans ? "Yes" : "No");
            writer.newLine();
            writer.flush();
        }
    }

    public static boolean isCBT(TreeNode root, int index, int totalNodes) {
        if (root == null)
            return true;
        if (index >= totalNodes)
            return false;
        return isCBT(root.left, 2 * index + 1, totalNodes) && isCBT(root.right, 2 * index + 2, totalNodes);
    }

    public static int totalNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + totalNodes(root.left) + totalNodes(root.right);
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
