/*
 * Copyright (c) 2018 Krishnakanth Yachreni. All rights reserved.
 */

package com.book.linkedList;

import java.util.HashSet;
import java.util.Set;

import com.book.linkedList.common.LinkedList;
import com.book.linkedList.common.Node;

public class RemoveDuplicate {
    /**
     * @author Krishnakanth Yachareni
     * @since 19-11-2018
     * <p>
     * Remove the duplicate elements from the LinkedList.
     * Solution is to first find the duplicates then remove for this I have used HashSet
     */
    public static void removeDuplicates() {
        Set<String> set = new HashSet<>();
        Node currentNode = LinkedList.head;
        Node prev = null;
        while (currentNode != null) {
            if (set.contains(currentNode.data)) {
                prev.next = currentNode.next;
                LinkedList.size--;
            } else {
                set.add(currentNode.data);
                prev = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("d");
        linkedList.add("c");
        linkedList.add("b");
        linkedList.add("h");
        System.out.println(linkedList);
        System.out.println("Size: " + linkedList.getSize());
        // After removing the duplicates.
        removeDuplicates();
        System.out.println(linkedList);
        System.out.println("Size: " + linkedList.getSize());
    }
}
