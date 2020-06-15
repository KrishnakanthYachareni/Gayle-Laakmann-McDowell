/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.linkedlist;

import com.book.linkedList.common.Node;

/**
 * Problem: Find the mid-point of a linked-list.
 * Rules:
 * 1. If size is odd return middle node.
 * 2. If size is even & given flag is true return mid node else return second mid node.
 */
public class LLMidElement {
    public static void main(String[] args) {
        Node n5 = new Node("13");
        Node n4 = new Node("12");
        Node n3 = new Node("-2");
        Node n2 = new Node("5");
        Node n1 = new Node("8");
        Node h = new Node("3");
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        h.next = n1;
        Node mid = findMid(h, true);
        System.out.println(mid.data);
    }

    public static Node findMid(Node h, boolean flag) {
        Node s = h, f = h;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if (f.next == null || flag) {
            return s;
        }
        return s.next;
    }
}
