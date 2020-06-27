/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTreeOperations {
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
            root = delete(root, 18);
            inOrder(root);
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


    public static TreeNode delete(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Case 1: Element with no child.
            if (root.left == null && root.right == null)
                root = null;
                // Case 2: Element with one child.
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                // Case 3: Element with two child's.
                // Replace the target element right node with minimum node of right of the tree from current node or
                // replace target left node with the maximum node of the left of the tree  from current node
                root.data = findMin(root.right); // or max
                root.right = delete(root.right, root.data);
            }
        }
        return root;
    }

    public static boolean search(TreeNode root, int x) {
        if (root == null)
            return false;
        if (x == root.data)
            return true;
        if (x < root.data)
            return search(root.left, x);
        return search(root.right, x);
    }

    public static int findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public static void inOrder(TreeNode root) { // LDR
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
