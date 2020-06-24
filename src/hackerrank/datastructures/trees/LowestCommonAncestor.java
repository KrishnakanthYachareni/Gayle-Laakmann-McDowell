/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.trees;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Iterative solution
     */
    public static Node lca(Node root, int v1, int v2) {
        Node th = root;
        while (root != null) {
            if ((v1 <= root.data && v2 >= root.data) || (v2 <= root.data && v1 >= root.data))
                return root;
            else {
                if (v1 < root.data && v2 < root.data)
                    root = root.left;
                else
                    root = root.right;
            }
        }
        return th;
    }

    /**
     * Recursive solution
     */
    public static Node lcaRec(Node root, int v1, int v2) {
        if (v1 < root.data && v2 < root.data)
            return lcaRec(root.left, v1, v2);
        if (v1 > root.data && v2 > root.data)
            return lcaRec(root.right, v1, v2);
        return root;
    }
}
