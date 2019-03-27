package chapter3.stack;

import java.util.EmptyStackException;

import chapter2.linkedList.common.Node;

public class Stack {

    private Node top;

    public void push(String data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public String pop() {
        if (null == top) {
            throw new EmptyStackException();
        }
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        Node tempNode = top;
        while (tempNode != null) {
            output.append(tempNode.data).append(",");
            tempNode = tempNode.next;
        }
        return output + "]";
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
    }
}