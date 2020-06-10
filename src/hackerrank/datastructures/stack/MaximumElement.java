/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @link https://www.hackerrank.com/challenges/maximum-element/problem
 */
public final class MaximumElement {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        s2.push(0);
        while (t-- > 0) {
            int query = sc.nextInt();
            switch (query) {
                case 1:
                    int x = sc.nextInt();
                    s1.push(x);
                    if (s1.peek() >= s2.peek()) {
                        s2.push(s1.peek());
                    }
                    break;
                case 2:
                    if (s1.peek().equals(s2.peek())) {
                        s2.pop();
                    }
                    s1.pop();
                    break;
                default:
                    System.out.println(s2.peek());
                    break;
            }
        }
    }
}
