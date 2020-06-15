/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

import hackerrank.contest.smartinterviews.linkedlist.Node;

/**
 * @link https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 */
public class DeleteDuplicateValue {
    public static void main(String[] args) {
        Node n10 = new Node(20);
        Node n9 = new Node(18);
        Node n8 = new Node(18);
        Node n7 = new Node(15);
        Node n6 = new Node(15);
        Node n5 = new Node(15);
        Node n4 = new Node(15);
        Node n3 = new Node(10);
        Node n2 = new Node(8);
        Node n1 = new Node(3);
        Node h = new Node(3);
        n9.next = n10;
        n8.next = n9;
        n7.next = n8;
        n6.next = n7;
        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        h.next = n1;
        removeDuplicates(h);
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode h) {
        SinglyLinkedListNode td = h;
        while (h.next != null) {
            if (h.data == h.next.data) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return td;
    }

    static void removeDuplicates(Node h) {
        while (h.next != null) {
            if (h.data == h.next.data) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
    }

    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
