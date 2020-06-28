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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of unique elements, construct a Binary Search Tree and print the tree in a Vertical Order, starting from the left-most node. Print the nodes in each vertical in sorted order.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-vertical-order-of-tree
 * <p>
 * Solution: The idea is to traverse verticall and add the vertical level nodes map with same key as level.
 * <p>
 * <------- Left <------ root ------> right -------->
 * v-3, v-2, v-1        v=0       v+1, v+2, v+3 ..etc
 */
public class VerticalOrderOfTree {
    private Map<Integer, List<Integer>> map;
    private int minLevel = 0, maxLevel = 0;

    public VerticalOrderOfTree() {
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            VerticalOrderOfTree ob = new VerticalOrderOfTree();
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.verticalOrder(root, 0);
            for (int i = ob.minLevel; i <= ob.maxLevel; i++) {
                List<Integer> li = ob.map.get(i);
                Collections.sort(li);
                for (int v : li)
                    writer.write(v + " ");
                writer.newLine();
            }
            writer.newLine();
            writer.flush();
        }
    }

    public void verticalOrder(TreeNode root, int v) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(root.data);
        minLevel = Math.min(minLevel, v);
        maxLevel = Math.max(maxLevel, v);
        verticalOrder(root.left, v - 1);
        verticalOrder(root.right, v + 1);
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
