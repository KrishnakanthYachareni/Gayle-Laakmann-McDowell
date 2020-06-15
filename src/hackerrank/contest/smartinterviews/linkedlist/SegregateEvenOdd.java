/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.linkedlist;


/**
 * Segregate even and odd numbers in a Linked List of integers, keeping the order of
 * even and odd numbers same
 */
public class SegregateEvenOdd {
    public static void main(String[] args) {
        Node n5 = new Node(13);
        Node n4 = new Node(12);
        Node n3 = new Node(2);
        Node n2 = new Node(5);
        Node n1 = new Node(8);
        Node h = new Node(3);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        h.next = n1;
        Node ans = oddEven(h);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
    }

    public static Node oddEven(Node h) {
        Node odd = new Node(0), even = new Node(0); //dummy
        Node oddTemp = odd, evenTemp = even;
        while (h != null) {
            if ((h.data & 1) != 1) {//Even
                even.next = new Node(h.data);
                even = even.next;
            } else {
                odd.next = new Node(h.data);
                odd = odd.next;
            }
            h = h.next;
        }
        odd.next = evenTemp.next;
        return oddTemp.next;
    }
}
