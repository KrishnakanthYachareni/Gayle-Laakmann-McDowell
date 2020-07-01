/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Here we use the Pair of two variables(data, depth).
 * 1. data: current node.
 * 2. depth: the depth of the current node from the root.
 * <p>
 * We use the vertical distance for indexing in recursion. If one node with the same vertical distance comes again,
 * we check if depth of new node is lower or higher with respect to the current node with same vertical distance in the map.
 * If depth of new node is lower, then we replace it.
 */
public class TopViewOfTree {
    private Map<Integer, Pair> map;

    public TopViewOfTree() {
        this.map = new TreeMap<>();
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TopViewOfTree ob = new TopViewOfTree();
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.topView(root, 0, 0);
            for (Map.Entry<Integer, Pair> entry : ob.map.entrySet()) {
                writer.write(entry.getValue().data + " ");
            }
            writer.newLine();
            writer.flush();
        }
    }

    public void topView(TreeNode root, int v, int depth) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new Pair(root.data, depth));
        } else if (map.get(v).depth > depth) {
            map.put(v, new Pair(root.data, depth));
        }
        topView(root.left, v - 1, depth + 1);
        topView(root.right, v + 1, depth + 1);
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
}
