/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package chapter2.linkedList;

import chapter2.linkedList.common.LinkedList;
import chapter2.linkedList.common.Node;

/**
 * @author Krishnakanth Yachareni
 * @since 20-11-2018
 * <p>
 * Implement an algorithm to delete a node in the middle
 * (i.e., any node bu the first and last node, not necessarily the exact middle) of a singleLinkedList, given only access to that node.
 */
public class DeleteMiddleNode {

    public static void removeMiddle() {
        Node slower = LinkedList.head;
        Node faster = LinkedList.head;
        Node prev = LinkedList.head;
        while (faster != null && faster.next != null) {
            prev = slower;
            slower = slower.next;
            faster = faster.next.next;
        }
        prev.next = slower.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("d");
        linkedList.add("c");
        linkedList.add("b");
        linkedList.add("h");
        System.out.println("Before Deletion: " + linkedList);
        removeMiddle();
        System.out.println("After Deletion: " + linkedList);
    }
}
