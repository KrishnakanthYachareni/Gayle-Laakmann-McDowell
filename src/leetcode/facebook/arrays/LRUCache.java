package leetcode.facebook.arrays;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1); // Dummy head
        tail = new Node(-1, -1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Adds a node before head (Frequently used items at the head)
    private void add(Node nn) {
        nn.prev = head;
        nn.next = head.next;
        head.next.prev = nn;
        head.next = nn;
    }

    private void delete(Node nn) {
        nn.next.prev = nn.prev;
        nn.prev.next = nn.next;
    }

    // Indicates the not frequently used items
    private Node deleteFromTail() {
        Node node = tail.prev;
        delete(node);
        return node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node); // Delete from the middle
            add(node); // Add the node to begging of the linked list
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // Delete the node from the list and add it to the beginning
            delete(node);
            add(node);
        } else {
            Node nn = new Node(key, value);
            map.put(key, nn);
            add(nn);
            if (map.size() > capacity) {
                Node node = deleteFromTail();
                map.remove(node.key);
            }
        }
    }
}
