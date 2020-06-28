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
 * Solution: The idea is same as vertical order except the levels are different.
 *     <p>
 *      v
 *     v   v+1
 *    v  v+1  v+2
 *   v  v+1   v+2
 *  v
 *  </p>
 */
public class DiagonalOrderOfTree {
    private Map<Integer, List<Integer>> map;
    private int minLevel = 0, maxLevel = 0;

    public DiagonalOrderOfTree() {
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            DiagonalOrderOfTree ob = new DiagonalOrderOfTree();
            TreeNode root = null;
            for (String num : ar) {
                root = ob.insert(root, Integer.parseInt(num));
            }
            ob.diagonalOrder(root, 0);
            for (int i = ob.minLevel; i <= ob.maxLevel; i++) {
                List<Integer> li = ob.map.get(i);
//                Collections.sort(li);
                for (int v : li)
                    writer.write(v + " ");
                writer.newLine();
            }
            writer.newLine();
            writer.flush();
        }
    }

    public void diagonalOrder(TreeNode root, int v) {
        if (root == null)
            return;
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(root.data);
        minLevel = Math.min(minLevel, v);
        maxLevel = Math.max(maxLevel, v);
        diagonalOrder(root.left, v);
        diagonalOrder(root.right, v + 1);
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
