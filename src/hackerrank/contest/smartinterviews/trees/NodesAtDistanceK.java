/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Given an array of unique elements, construct a Binary Search Tree and find the number of nodes at a distance K from the given source node S.
 * Distance is defined as the number of edges between 2 nodes.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-nodes-at-distance-k
 */
//TODO: Some issues for few test cases with this code.
public class NodesAtDistanceK {
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
            String[] str = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[2]);
            TreeNode s = null;
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                int in = Integer.parseInt(num);
                TreeNode node = new TreeNode(in);
                if (Integer.parseInt(str[1]) == in)
                    s = node;
                root = insert(root, node);
            }
            int ans = nodesAtK(root, s, k);
            System.out.println(ans);
        }
    }

    public static int nodesAtK(TreeNode root, TreeNode s, int k) {
        LinkedList<TreeNode> path = new LinkedList<>();
        helper(root, s, path);
        int ans = count(s, k);
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i).right == path.get(i - 1))
                ans += count(path.get(i).left, k < path.size() ? 0 : k - i - 1);
            else
                ans += count(path.get(i).right, k < path.size() ? 0 : k - i - 1);
        }
        return ans + 1;
    }

    /**
     * This method count the number of nodes from given node to given distance.
     */
    private static int count(TreeNode node, int d) {
        if (node == null)
            return 0;
        if (d == 0)
            return 1;
        return count(node.left, d - 1) + count(node.right, d - 1);
    }

    /**
     * This method finds the paths from root to given node x.
     */
    private static boolean helper(TreeNode root, TreeNode s, LinkedList<TreeNode> path) {
        if (root == null)
            return false;
        path.addFirst(root);
        if (root == s)
            return true;
        if (helper(root.left, s, path) || helper(root.right, s, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    private static TreeNode insert(TreeNode root, TreeNode x) {
        if (root == null)
            return x;
        if (x.data < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }
}
