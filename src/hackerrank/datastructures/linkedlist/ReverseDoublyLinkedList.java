/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.linkedlist;

/**
 * @link https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
 */
public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListNode n2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode n1 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode h = new DoublyLinkedListNode(1);
        h.next = n1;
        n1.next = n2;
        n1.prev = h;
        n2.prev = n1;
        DoublyLinkedListNode rev = reverse(h);
        while (rev != null) {
            System.out.print(rev.data + " ");
            rev = rev.next;
        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode th = head, temp;
        while (head != null) {
            temp = head.prev;
            head.prev = head.next;
            head.next = temp;
            th = head;
            head = head.prev;
        }
        return th;
    }

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next, prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }
}


