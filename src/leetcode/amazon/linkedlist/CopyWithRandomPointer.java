package leetcode.amazon.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
//TODO: Look for O(1) solution LC: 3rd sol
public class CopyWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // TC = O(N), SC = O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Link cloned copy of each node in the middle of each original nodes
        Node curr = head;
        while (curr != null) {
            Node nn = new Node(curr.val);
            nn.next = curr.next;
            curr.next = nn;
            curr = nn.next;
        }

        // Step 2: Assign random pointers to cloned nodes
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        // Step 3: Unlink the original nodes
        Node orig = head, copy = head.next;
        Node temp = head.next;
        while (orig != null) {
            orig.next = orig.next.next;
            copy.next = copy.next != null ? copy.next.next : null;
            copy = copy.next;
            orig = orig.next;
        }
        return temp;
    }


    /*// TC = O(N), SC = O(N)
    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        if (this.map.containsKey(head))
            return this.map.get(head);

        Node nn = new Node(head.val);

        this.map.put(head, nn);

        nn.next = copyRandomList(head.next);
        nn.random = copyRandomList(head.random);

        return nn;
    }*/
}
