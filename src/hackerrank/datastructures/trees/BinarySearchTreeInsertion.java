/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
 */
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTreeInsertion {

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int height(Node root) {
        // Write your code here.
        Node left = root, right = root;
        int leftCount = 0, rightCount = 0;
        while(null != left) {
            if(left.left != null)
                leftCount++;
            left = left.left;
        }

        while(null != right) {
            if(right.right != null)
                rightCount++;
            right = right.right;
        }
        return Math.max(leftCount, rightCount);
    }

    // Complete the function for inserting the elements in BST
    public static Node insert(Node root, int data) {
        if (null == root) {
            root = new Node(data);
        } else {
            if (data <= root.data) {
                if (null == root.left)
                    root.left = new Node(data);
                else
                    insert(root.left, data);
            } else {
                if (null == root.right)
                    root.right = new Node(data);
                else
                    insert(root.right, data);
            }
        }
        return root;
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
//        preOrder(root);
        System.out.println(height(root));
    }
}
