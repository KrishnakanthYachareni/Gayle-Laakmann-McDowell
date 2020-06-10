/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Perform push and pop operations on stack. Implement Stacks and avoid using inbuilt library.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-implement-stack
 */
public final class StackImplArray {
    private static int[] stack;
    private static int top = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        stack = new int[n];
        while (n > 0) {
            String[] op = reader.readLine().split(" ");
            if (op[0].equals("push")) {
                push(Integer.parseInt(op[1]));
            } else {
                pop();
            }
            n--;
        }
    }

    public static void push(int x) {
        if (top + 1 > stack.length) {
            System.out.println("Stack Overflow");
        } else {
            stack[top++] = x;
        }
    }

    public static void pop() {
        if (top <= 0) {
            System.out.println("Empty");
        } else {
            System.out.println(stack[top - 1]);
            top--;
        }
    }
}
