/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array, print the median for the sub-array 0 to i, for every i, 0<=i<=N-1.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-anytime-median
 */
public class AnytimeMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] ar = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            median(ar, n);
            System.out.println();
        }
    }

    private static void median(int[] ar, int n) {
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder()); //MaxQueue
        PriorityQueue<Integer> b = new PriorityQueue<>(); //MinQueue
        for (int i = 0; i < n; i++) {
            if (!s.isEmpty() && ar[i] < s.peek())
                s.add(ar[i]);
            else
                b.add(ar[i]);
            int diff = s.size() - b.size();
            if (diff != 0 && diff != 1) {
                if (s.size() < b.size())
                    s.add(b.poll());
                else {
                    if (!s.isEmpty())
                        b.add(s.poll());
                }
            }
            System.out.print(s.peek() + " ");
        }
    }
}
