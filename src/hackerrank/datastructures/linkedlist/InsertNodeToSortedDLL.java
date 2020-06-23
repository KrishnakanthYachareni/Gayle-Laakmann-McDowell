/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

/**
 * @link https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 */
public class InsertNodeToSortedDLL {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode nn = new DoublyLinkedListNode(data);
        DoublyLinkedListNode cur = head;
        while (cur != null) {
            if (cur.data > data) {
                if (cur.prev != null) {
                    nn.next = cur;
                    nn.prev = cur.prev;
                    cur.prev.next = nn;
                    cur.prev = nn;
                } else {
                    nn.next = cur;
                    cur.prev = nn;
                    head = nn;
                }
                return head;
            }
            if (cur.next == null) {
                cur.next = nn;
                nn.prev = cur;
                return head;
            }
            cur = cur.next;
        }
        return nn;
    }
}
