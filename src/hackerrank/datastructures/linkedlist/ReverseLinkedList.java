/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

import com.book.linkedList.common.Node;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node n4 = new Node("12");
        Node n3 = new Node("-2");
        Node n2 = new Node("5");
        Node n1 = new Node("8");
        Node h = new Node("3");
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        h.next = n1;
        Node reverseList = reverseRecursive(h);
        while (reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }

    public static Node reverseRecursive(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        Node t = reverseRecursive(h.next);
        h.next.next = h;
        h.next = null;
        return t;
    }

    public static Node reverseIterative(Node head) {
        Node prev = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}


