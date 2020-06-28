/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Consider lines of slope -1 passing between nodes.
 * <p>
 * Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.
 *
 * @link https://www.interviewbit.com/problems/diagonal-traversal/
 */
public class DiagonalTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    int minLevel = 0, maxLevel = 0;
    Map<Integer, List<Integer>> map = new TreeMap<>();

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        diagonal(A, 0);
        for (int i = minLevel; i <= maxLevel; i++) {
            ans.addAll(map.get(i));
        }
        return ans;
    }

    public void diagonal(TreeNode root, int v) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(root.val);
        minLevel = Math.min(minLevel, v);
        maxLevel = Math.max(maxLevel, v);
        diagonal(root.left, v + 1);
        diagonal(root.right, v);
    }
}
