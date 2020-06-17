/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;


import hackerrank.contest.smartinterviews.linkedlist.Node;

/**
 * @link https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 */
public class GetNodeValue {
    public static void main(String[] args) {
        Node n5 = new Node(15);
        Node n4 = new Node(15);
        Node n3 = new Node(10);
        Node n2 = new Node(8);
        Node n1 = new Node(3);
        Node h = new Node(3);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        h.next = n1;
        System.out.println(GetNode(h, 2));
    }

    static int GetNode(Node head, int n) {
        Node pointer = head;
        int pointerPosition = 0;
        while (head.next != null) {
            head = head.next;
            if (pointerPosition < n) {
                pointerPosition++;
            } else {
                pointer = pointer.next;
            }
        }

        return pointer.data;
    }
}
