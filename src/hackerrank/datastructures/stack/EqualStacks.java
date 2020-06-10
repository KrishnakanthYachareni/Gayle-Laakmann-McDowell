/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.stack;

import java.util.Stack;

/**
 * TODO: Javadoc
 */
public final class EqualStacks {
    public static void main(String[] args) {
        int[] h1 = {3, 2, 1, 1, 1};
        int[] h2 = {4, 3, 2};
        int[] h3 = {1, 1, 4, 1};
        int ans = equalStacks(h1, h2, h3);
        System.out.println(ans);
    }

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int s1Sum = 0, s2Sum = 0, s3Sum = 0;
        // Prefix sum stack
        for (int i = h1.length - 1; i >= 0; i--) {
            s1Sum += h1[i];
            s1.push(s1Sum);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            s2Sum += h2[i];
            s2.push(s2Sum);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            s3Sum += h3[i];
            s3.push(s3Sum);
        }
        while (true) {
            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                return 0;
            }
            s1Sum = s1.peek();
            s2Sum = s2.peek();
            s3Sum = s3.peek();
            // If sum of all three stack are equal.
            if (s1Sum == s2Sum && s2Sum == s3Sum) {
                return s1Sum;
            }
            // Finding the stack with maximum sum and
            // removing its top element.
            if (s1Sum >= s2Sum && s1Sum >= s3Sum) {
                s1.pop();
            } else if (s2Sum >= s3Sum) {
                s2.pop();
            } else {
                s3.pop();
            }
        }
    }
}
