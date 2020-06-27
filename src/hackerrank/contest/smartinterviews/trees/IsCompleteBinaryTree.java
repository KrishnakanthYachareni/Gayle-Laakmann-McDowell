/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-is-complete-binary-tree
 */
public class IsCompleteBinaryTree {
    static class TreeNode {
        public int data, level;
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
            boolean ans = isCBT(root);
            writer.write(ans ? "Yes" : "No");
            writer.newLine();
            writer.flush();
        }
    }

    /**
     * Recursive solution
     * <p>
     * Complexity: O(n), O(1)
     */
    public static boolean isCBT(TreeNode root) {
        if (root.left.left == null || root.right.right == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        return isCBT(root.left) && isCBT(root.right);
    }

    /**
     * Iterative solution
     * <p>
     * Complexity: O(n), O(n)
     */
    public static boolean isFBTIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur != null && (cur.left == null && cur.right == null)) {
                return false;
            }
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
        return true;
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
