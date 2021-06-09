/*
 * Copyright (c) 2021 by Krishnakanth Yachareni
 */

package leetcode.amazon;

/**
 * Problem: Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
 * <p>
 * Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
 * <p>
 * Link: https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
