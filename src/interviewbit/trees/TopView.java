/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit.trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @link https://www.interviewbit.com/problems/top-view/
 */
public class TopView {
    static class TreeNode {
        public int val;
        public TreeNode left, right;

        TreeNode(int data) {
            this.val = data;
            this.left = this.right = null;
        }
    }

    static class Pair {
        int data, depth;

        Pair(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }

    static Map<Integer, Pair> map = new TreeMap<>();

    public ArrayList<Integer> solve(TreeNode A) {
        solve(A, 0, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }
        map = new TreeMap<>();
        return ans;
    }

    private void solve(TreeNode root, int v, int l) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new Pair(root.val, l));
        } else if (map.get(v).depth > l) {
            map.put(v, new Pair(root.val, l));
        }
        solve(root.left, v - 1, l + 1);
        solve(root.right, v + 1, l + 1);
    }
}
