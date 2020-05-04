/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package com.book.linkedList.common;

/**
 * @author Krishnakanth Yachareni
 * @since 16-11-2018
 * <p>
 * This common code for all LinkedList related problems
 * Basic LinkedList operations implemented in java.
 */
public class LinkedList {
    public static int size;
    public static Node head;

    public int getSize() {
        return size;
    }

    public void add(String data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        Node current = head;
        if (current != null) {
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    return false;
                }
                current = current.next;
            }
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String output = "[";
        if (head != null) {
            Node current = head;
            while (current != null) {
                output += current.data + ",";
                current = current.next;
            }
        }
        return output.substring(0, output.lastIndexOf(",")) + "]";
    }
}
