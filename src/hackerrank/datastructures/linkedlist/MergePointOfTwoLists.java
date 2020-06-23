/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

/**
 * @link https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 */
public class MergePointOfTwoLists {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode h2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode h1 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode h = new SinglyLinkedListNode(1);
        h.next = h1;
        h1.next = h2;
    }

    static int findMergeNode(SinglyLinkedListNode h1, SinglyLinkedListNode h2) {
        int n = size(h1);
        int m = size(h2);
        int d = Math.abs(n - m);
        // Skip d nodes and make both the lists are same size.
        if (n > m) {
            h1 = skipNodes(h1, d);
        } else {
            h2 = skipNodes(h2, d);
        }

        while (h1 != null && h2 != null && h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1 != null ? h1.data : -1;
    }

    private static SinglyLinkedListNode skipNodes(SinglyLinkedListNode h, int d) {
        if (d == 0) {
            return h;
        }
        return skipNodes(h.next, d - 1);
    }

    private static int size(SinglyLinkedListNode h) {
        if (h == null)
            return 0;
        return 1 + size(h.next);
    }
}

