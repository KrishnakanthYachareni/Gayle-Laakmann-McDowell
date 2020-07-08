/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given the preorder and inorder traversals of a binary tree with unique elements,
 * print the PostOrder Traversals of the tree
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-preorder-inorder-to-postorder
 */
public class PreOrderAndInOrderToPostOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] pre = reader.readLine().trim().split(" ");
            String[] in = reader.readLine().trim().split(" ");
            PreOrderAndInOrderToPostOrder ob = new PreOrderAndInOrderToPostOrder();
            ob.postOrder(pre, in, 0, n - 1);
            System.out.println();
        }
    }

    int pos = 0;

    private void postOrder(String[] pre, String[] in, int low, int high) {
        if (low > high)
            return;
        int idx = search(pre[pos], in, low, high);
        pos++;
        postOrder(pre, in, low, idx - 1); // Left sub tree
        postOrder(pre, in, idx + 1, high); // Right sub tree.
        System.out.print(in[idx] + " "); //root
    }

    private int search(String parent, String[] in, int low, int high) {
        for (int i = low; i <= high; i++) {
            if (in[i].equals(parent))
                return i;
        }
        return 0;
    }
}
