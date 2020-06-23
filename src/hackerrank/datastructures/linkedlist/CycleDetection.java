/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

/**
 * @link https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */
public class CycleDetection {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasCycle(SinglyLinkedListNode h) {
        SinglyLinkedListNode s = h, f = h;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }
}
