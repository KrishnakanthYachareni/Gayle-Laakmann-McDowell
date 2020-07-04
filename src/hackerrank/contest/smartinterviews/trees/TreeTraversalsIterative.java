/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-tree-traversals
 */
public class TreeTraversalsIterative {
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
            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
            System.out.println();
        }
    }

    // Pre-Order Iterative Traversal
    public static void preOrder(TreeNode root) { // DLR
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode x = s.pop();
            if (x.right != null)
                s.push(x.right);
            if (x.left != null)
                s.push(x.left);
            System.out.print(x.data + " ");
        }
    }

    // In-Order Iterative Traversal
    public static void inOrder(TreeNode root) { // LDR
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (true) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            if (st.size() != 0) {
                cur = st.pop();
                System.out.print(cur.data + " ");
                cur = cur.right;
            } else
                break;
        }
    }


    // Post-Order Iterative Traversal
    public static void postOrder(TreeNode root) { // LRD
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode x = s.pop();
            if (x.left != null)
                s.push(x.left);
            if (x.right != null)
                s.push(x.right);
            ans.push(x.data);
        }
        while (!ans.isEmpty())
            System.out.print(ans.pop() + " ");
    }

    public static TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        }
        if (x < root.data) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
