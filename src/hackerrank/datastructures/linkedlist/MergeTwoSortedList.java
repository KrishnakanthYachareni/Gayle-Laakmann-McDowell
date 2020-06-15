/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

import hackerrank.contest.smartinterviews.linkedlist.Node;

/**
 * @link https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        //List one
        Node n2 = new Node(8);
        Node n1 = new Node(5);
        Node h1 = new Node(3);
        n1.next = n2;
        h1.next = n1;

        Node n5 = new Node(13);
        Node n4 = new Node(12);
        Node h2 = new Node(2);
        n4.next = n5;
        h2.next = n4;

        Node ans = mergeLists(h1, h2);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
    }

    public static Node mergeLists(Node h1, Node h2) {
        Node d = new Node(0);
        Node td = d;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                d.next = new Node(h1.data);
                h1 = h1.next;
            } else {
                d.next = new Node(h2.data);
                h2 = h2.next;
            }
            d = d.next;
        }
        while (h1 != null) {
            d.next = new Node(h1.data);
            h1 = h1.next;
            d = d.next;
        }
        while (h2 != null) {
            d.next = new Node(h2.data);
            h2 = h2.next;
            d = d.next;
        }
        return td.next;
    }
}
