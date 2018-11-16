/*
 * Copyright (c) 2018 Krishnakanth Yachreni. All rights reserved.
 */

package chapter2.linkedList;

import java.util.HashSet;
import java.util.Set;

class Node {
    Node next;
    String data;

    Node(String data) {
        this.data = data;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    static int size;
    Node head;

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
            currentNode.setNext(newNode);
        }
        size++;
    }

    public void removeDuplicates() {
        Set<String> set = new HashSet<>();
        Node currentNode = head;
        Node prev = null;
        while (currentNode != null) {
            if (set.contains(currentNode.data)) {
                prev.setNext(currentNode.getNext());
                size--;
            } else {
                set.add(currentNode.data);
                prev = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public String toString() {
        String output = "[";
        if (head != null) {
            Node current = head;
            while (current != null) {
                output += current.data + ",";
                current = current.getNext();
            }
        }
        return output.substring(0, output.lastIndexOf(",")) + "]";
    }
}

public class RemoveDuplicate {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("b");
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());
        // After removing the duplicates.
        linkedList.removeDuplicates();
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());
    }
}
