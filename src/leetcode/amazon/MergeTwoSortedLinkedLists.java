/*
 * Copyright (c) 2021 by Krishnakanth Yachareni
 */

package leetcode.amazon;

/**
 * Problem: Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Solution: Use two pointer technique to solve the problem.
 * <p>
 * Let n, m are lengths of two sorted arrays.
 * TC = O(n + m)
 * SC = O(1)
 * <p>
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode ans = new MergeTwoSortedLinkedLists().mergeTwoLists(listNode, listNode2);
        while (ans != null) {
            System.out.println(ans.val + " -->");
            ans = ans.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode temp = new ListNode(0); //Dummy Head
        ListNode ans = temp; //To Keep the initial address
        while (null != p1 && null != p2) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        while (null != p1) {
            temp.next = p1;
            p1 = p1.next;
            temp = temp.next;
        }
        while (null != p2) {
            temp.next = p2;
            p2 = p2.next;
            temp = temp.next;
        }
        return ans.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
