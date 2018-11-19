/*
 * Copyright (c) 2018 Krishnakanth Yachareni. All rights reserved.
 */

package important.algo;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value <= data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(data + " ");
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        System.out.print("************** Binary Search Tree Implementation ************\n");
        Node node = new Node(100);
        node.insert(20);
        node.insert(200);
        node.insert(10);
        node.insert(30);
        node.insert(150);
        node.insert(300);
        System.out.print("InOrder :");
        node.printInOrder();
        System.out.print("\nPreOrder :");
        node.printPreOrder();
        System.out.print("\nPostOrder :");
        node.printPostOrder();
        System.out.println("\n" + node.contains(23));
    }
}
