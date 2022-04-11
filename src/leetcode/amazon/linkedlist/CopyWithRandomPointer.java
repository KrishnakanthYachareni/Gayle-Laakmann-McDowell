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
    }
}
