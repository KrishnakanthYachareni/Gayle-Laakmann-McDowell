/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

/**
 * @link https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
 */
public class BSTInsertion {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

}
