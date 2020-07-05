/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We use PriorityQueue class to implement Heaps in Java. By default Min Heap is implemented by this class.
 * To implement Max Heap, we use Collections.reverseOrder()
 */
public class MaxHeapBuiltIn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //MinHeap
        while (t-- > 0) {
            String[] in = reader.readLine().trim().split(" ");
            switch (in[0]) {
                case "insert":
                    pq.add(Integer.parseInt(in[1]));
                    break;
                case "getMin":
                    writer.write(!pq.isEmpty() ? String.valueOf(pq.peek()) : "Empty");
                    writer.newLine();
                    break;
                case "delMin":
                    pq.poll();
                    break;
            }
        }
        writer.flush();
    }
}
