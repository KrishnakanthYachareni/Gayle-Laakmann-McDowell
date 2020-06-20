/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit.linkedlist;

/**
 * @link https://www.interviewbit.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode d = new ListNode(0);
        ListNode td = d;
        while (A != null && B != null) {
            if (A.val < B.val) {
                d.next = A;
                A = A.next;
            } else {
                d.next = B;
                B = B.next;
            }
            d = d.next;
        }
        while (A != null) {
            d.next = A;
            d = d.next;
            A = A.next;
        }
        while (B != null) {
            d.next = B;
            d = d.next;
            B = B.next;
        }
        return td.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
