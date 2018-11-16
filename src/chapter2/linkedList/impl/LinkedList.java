/*
 * Copyright (c) 2018 MasterCard. All rights reserved.
 */

package chapter2.linkedList.impl;

/**
 * @author Krishnakanth Yachareni
 * @since 16-11-2018
 * <p>
 * Basic LinkedList operations implemented in java.
 */
class Demo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Krishna");
        linkedList.add("Kanth");
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        linkedList.remove(0);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }
}

class Node {
    Node next;
    String data;

    public Node(String data) {
        next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class LinkedList {
    private static int size;
    private Node head;

    public int size() {
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

    public boolean remove(int index) {
        Node current = head;
        if (current != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return false;
                }
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
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
                output += current.getData() + ",";
                current = current.getNext();
            }
        }
        return output.substring(0, output.lastIndexOf(",")) + "]";
    }
}
