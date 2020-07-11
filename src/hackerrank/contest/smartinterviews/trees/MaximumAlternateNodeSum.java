/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of unique elements, construct a Binary Search Tree and find the maximum sum of nodes,
 * with the constraint that if you select a node, you cannot select any of its immediate child nodes.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-maximum-alternate-nodes-sum
 * //TODO: Solution is not correct. Work on this further.
 */
public class MaximumAlternateNodeSum {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] ar = reader.readLine().trim().split(" ");
            TreeNode root = null;
            for (String num : ar) {
                root = insert(root, Integer.parseInt(num));
            }
            int sum = calSum(root, 0);
            System.out.println(sum);
        }
    }

    static int sum = 0;

    public static int calSum(TreeNode root, int level) {
        if (root == null)
            return 0;
        if (level % 2 == 0) {
            sum += root.data;
        }
        calSum(root.left, level + 1);
        calSum(root.right, level + 1);
        return sum;
    }

    private static TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);
        return root;
    }
}
