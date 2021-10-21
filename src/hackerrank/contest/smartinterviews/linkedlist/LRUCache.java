/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implement LRU(Least Recently Used) Cache
 * <p>
 * Solution:  Use HashMap to keep the entries and their address of Dll nodes.
 * Use doubly linked list to remove least recently used entry in cache in O(1) times.
 * <p>
 * Complexity: O(1)
 */
public class LRUCache {
    public static void main(String[] args) {
        int[] ar = {5, 10, 3, 10, 8, 12, 3, 15, 12, 2};
        LRU(ar, ar.length, 4);
    }

    public static void LRU(int[] ar, int n, int k) {
        Map<Integer, Node> hm = new HashMap<>();
        Node h = new Node(-1);
        Node t = h;
        for (int i = 0; i < n; i++) {
            // case a) Not Present + Not Full
            if (!hm.containsKey(ar[i]) && hm.size() < k) {
                Node nn = new Node(ar[i]);
                t.next = nn;
                nn.prev = t;
                t = t.next;
                hm.put(ar[i], nn);
            } else if (hm.containsKey(ar[i])) { // case b) Present
                Node x = hm.get(ar[i]);
                x.prev.next = x.next;
                x.next.prev = x.prev;
                t.next = x;
                x.prev = t;
                t = t.next; // t= x;
                t.next = null; // nullify x
            } else if (!hm.containsKey(ar[i]) && hm.size() == k) { // case c) Not Present + Full
                hm.remove(h.next.data);
                Node nn = new Node(ar[i]);
                h.next = h.next.next;
                h.next.prev = h;
                t.next = nn;
                nn.prev = t;
                t = t.next;
                hm.put(ar[i], nn);
            }
            System.out.println("Cache Data : " + hm.keySet());
        }
    }

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }
}


// OR https://leetcode.com/problems/lru-cache/solution/

class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
