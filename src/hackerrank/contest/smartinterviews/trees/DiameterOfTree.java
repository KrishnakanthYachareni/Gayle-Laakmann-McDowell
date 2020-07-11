/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of unique elements, construct a Binary Search Tree and find the diameter of the tree.
 * Diameter is defined as the number of nodes on the longest path between 2 nodes of the tree.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-diameter-of-a-tree
 * //TODO: Work in Progress.
 */
public class DiameterOfTree {
    private Map<Integer, List<Integer>> map;

    public DiameterOfTree() {
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            DiameterOfTree ob = new DiameterOfTree();
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.diaMeter(root, 0);
            writer.write(ob.diameter + "\n");
            writer.flush();
        }
    }

    int diameter = 0;

    public void diaMeter(TreeNode root, int l) {
        if (root == null)
            return;
        if (!map.containsKey(l)) {
            map.put(l, new ArrayList<>());
        }
        diameter = Math.max(diameter, map.get(l).size());
        map.get(l).add(root.data);
        diaMeter(root.left, l + 1);
        diaMeter(root.right, l + 1);
    }

    private TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
