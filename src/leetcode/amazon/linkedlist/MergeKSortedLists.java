package leetcode.amazon.linkedlist;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    // O(N log K)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if (curr.next != null)
                queue.add(curr.next);
        }

        return temp.next;
    }

    // We need to merge k lists by merging (k-1) times and using the MergeTwoLists
    // O(k* N)
    /*public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        for (ListNode node : lists) {
            result = mergeTwoLists(result, node);
        }

        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }*/
}
