/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.Scanner;

public class HeightOfBinaryTree {

    /**
     * Complete below function to compute height of binary tree
     * <p>
     * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
     * https://www.youtube.com/watch?v=_SiwrPXG9-g
     */
    public static int height(Node root) {
        // Write your code here.
        if (null == root) {
            return -1;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
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
