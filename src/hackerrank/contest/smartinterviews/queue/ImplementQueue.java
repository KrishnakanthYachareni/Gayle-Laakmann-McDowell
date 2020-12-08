/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-implement-queue
 */
public class ImplementQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int f = -1, r = -1;
        int t = Integer.parseInt(reader.readLine());
        int[] queue = new int[t];
        while (t-- > 0) {
            String[] ar = reader.readLine().trim().split(" ");
            if ("Enqueue".equals(ar[0])) {
                int x = Integer.parseInt(ar[1]);
                queue[++r] = x;
            } else {
                if (f == r) {
                    System.out.println("Empty");
                } else {
                    System.out.println(queue[++f]);
                }
            }
        }
    }
}
