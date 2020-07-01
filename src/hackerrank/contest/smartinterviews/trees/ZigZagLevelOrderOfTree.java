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
 * Given an array of unique elements, construct a Binary Search Tree and print the Level Order of the tree in a zig-zag fashion. Assume root is at level-1, zig-zag means that nodes at even levels will be printed left to right and the nodes at odd levels will be printed from right to left.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-zig-zag-level-order-of-tree
 */
public class ZigZagLevelOrderOfTree {
    private int maxLevel = 0;
    private Map<Integer, List<Integer>> map;

    public ZigZagLevelOrderOfTree() {
        this.map = new TreeMap<>();
    }

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
            ZigZagLevelOrderOfTree ob = new ZigZagLevelOrderOfTree();
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.zigZagOrder(root, 1);
            for (int i = 1; i <= ob.maxLevel; i++) {
                List<Integer> li = ob.map.get(i);
                if ((i & 1) != 1) { // Even Level
                    for (int val : li)
                        System.out.print(val + " ");
                } else { //  Odd Level
                    for (int j = li.size() - 1; j >= 0; j--) // Print Right to left (reverse order)
                        System.out.print(li.get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    public void zigZagOrder(TreeNode root, int v) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(root.data);
        maxLevel = Math.max(maxLevel, v);
        zigZagOrder(root.left, v + 1);
        zigZagOrder(root.right, v + 1);
    }

    public TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }
}
