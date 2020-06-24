/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */
public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }
}
