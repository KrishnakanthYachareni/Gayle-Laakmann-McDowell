/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit.linkedlist;


/**
 * @link https://www.interviewbit.com/problems/palindrome-list/
 */
public class PalindromeList {
    public static void main(String[] args) {
        ListNode n2 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode h = new ListNode(1);
        n1.next = n2;
        h.next = n1;
        System.out.println(isPalindrome(h));
    }

    public static int isPalindrome(ListNode h) {
        ListNode mid = findMid(h, true);
        ListNode h2 = mid.next;
        mid.next = null;
        h2 = reverse(h2);
        while (h2 != null && h != null) {
            if (h.val != h2.val) {
                return 0;
            }
            h2 = h2.next;
            h = h.next;
        }
        return 1;
    }

    private static ListNode findMid(ListNode h, boolean flag) {
        ListNode s = h, f = h;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if (f.next == null || flag) {
            return s;
        }
        return s.next;
    }

    private static ListNode reverse(ListNode h) {
        ListNode prev = null, temp;
        while (h != null) {
            temp = h.next;
            h.next = prev;
            prev = h;
            h = temp;
        }
        return prev;
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
