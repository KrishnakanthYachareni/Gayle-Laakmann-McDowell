package leetcode.amazon.linkedlist;

public class ReverseLinkedList {

    // Iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, t;
        while (head != null) {
            t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }
}
