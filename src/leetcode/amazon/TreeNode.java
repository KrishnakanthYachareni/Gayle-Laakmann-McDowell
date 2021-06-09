/*
 * Copyright (c) 2021 by Krishnakanth Yachareni
 */

package leetcode.amazon;

public class TreeNode {
    protected int val;
    protected TreeNode left;
    protected TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
