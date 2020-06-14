/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.datastructures.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

/**
 * @link https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] ar = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ans = largestRectangle(ar, n);
            writer.write(String.valueOf(ans));
            writer.newLine();
            writer.flush();
        }
    }

    private static int largestRectangle(int[] ar, int n) {
        int ans = 0;
        int[] p1 = p1(ar, n);
        int[] p2 = p2(ar, n);
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (p2[i] - p1[i] - 1) * ar[i]);
        }
        return ans;
    }

    /**
     * Find Indexes of First smaller element for each ar[i] on left side of it.
     */
    private static int[] p1(int[] ar, int n) {
        int[] p1 = new int[n];
        Arrays.fill(p1, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && ar[i] <= ar[st.peek()]) {
                st.pop();
            }
            if (st.size() != 0) {
                p1[i] = st.peek();
            }
            st.push(i);
        }
        return p1;
    }

    /**
     * Find Indexes of First smaller element for each ar[i] on right side of it.
     */
    private static int[] p2(int[] ar, int n) {
        int[] p2 = new int[n];
        Arrays.fill(p2, n);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && ar[i] < ar[st.peek()]) {
                p2[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return p2;
    }
}
