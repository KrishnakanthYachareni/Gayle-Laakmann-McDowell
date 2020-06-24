/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.Scanner;

/**
 * @link https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */
public class HeightOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Complete below function to compute height of binary tree
     * <p>
     * https://www.youtube.com/watch?v=_SiwrPXG9-g
     */
    public static int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
