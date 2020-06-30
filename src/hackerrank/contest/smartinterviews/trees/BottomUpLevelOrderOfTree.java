/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of unique elements, construct a Binary Search Tree and print the Level Order of the tree, not top-down, but bottom-up.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-bottom-up-level-order-of-tree
 */
public class BottomUpLevelOrderOfTree {
    private int maxLevel = 0;
    private Map<Integer, List<Integer>> map;

    public BottomUpLevelOrderOfTree() {
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            BottomUpLevelOrderOfTree ob = new BottomUpLevelOrderOfTree();
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.bottomUpLevelOrder(root, 0);
            for (int i = ob.maxLevel; i >= 0; i--) {
                for (int val : ob.map.get(i))
                    System.out.print(val + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * Complexity: O(n), O(n)
     */
    public void bottomUpLevelOrder(TreeNode root, int v) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(root.data);
        maxLevel = Math.max(maxLevel, v);
        bottomUpLevelOrder(root.left, v + 1);
        bottomUpLevelOrder(root.right, v + 1);
    }

    public TreeNode insert(TreeNode root, int x) {
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
