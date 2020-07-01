/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
 * Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree
 *
 * @link https://www.hackerrank.com/challenges/tree-top-view/problem
 */
public class TopView {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Pair {
        int data, depth;

        Pair(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }

    static Map<Integer, Pair> map = new TreeMap<>();

    public static void topView(Node root) {
        solve(root, 0, 0);
        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    private static void solve(Node root, int v, int l) {
        if (root == null)
            return;
        if (!map.containsKey(v))
            map.put(v, new Pair(root.data, l));
        else if (map.get(v).depth > l)
            map.put(v, new Pair(root.data, l));
        solve(root.left, v - 1, l + 1);
        solve(root.right, v + 1, l + 1);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
