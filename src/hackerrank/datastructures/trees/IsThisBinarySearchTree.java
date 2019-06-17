/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.Scanner;

import static hackerrank.datastructures.trees.BinarySearchTreeInsertion.insert;

/**
 * https://www.hackerrank.com/challenges/is-binary-search-tree/problem
 * <p>
 * https://www.youtube.com/watch?v=i_Q0v_Ct5lY&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=6
 */
public class IsThisBinarySearchTree {
    /**
     * Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge.
     * Hint: you may want to write one or more helper functions.
     * <p>
     * The Node class is defined as follows:
     * class Node {
     * int data;
     * Node left;
     * Node right;
     * }
     **/
    public static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node root, int min, int max) {
        if (null == root) {
            return true;
        }
        if (min > root.data || max < root.data) {
            return false;
        }
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);
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
        System.out.println(checkBST(root) ? "YES" : "NO");
    }
}
