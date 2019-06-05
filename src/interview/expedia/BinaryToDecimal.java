/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.expedia;

public class BinaryToDecimal {

    public static void main(String[] args) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(0);
        node.next = new SinglyLinkedListNode(1);
        node.next.next = new SinglyLinkedListNode(0);
        node.next.next.next = new SinglyLinkedListNode(0);
        node.next.next.next.next = new SinglyLinkedListNode(1);
        node.next.next.next.next.next = new SinglyLinkedListNode(1);
        System.out.println(getNumber(node));
    }

    private static long getNumber(SinglyLinkedListNode binary) {
        long res = 0;
        while (null != binary) {
            res = (res << 1) + binary.data;
            binary = binary.next;
        }
        return res;
    }
}
