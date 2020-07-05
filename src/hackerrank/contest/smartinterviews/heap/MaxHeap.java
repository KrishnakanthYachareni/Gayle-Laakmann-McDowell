/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement MaxHeap using 1-based index.
 */
public class MaxHeap {
    static List<Integer> ar;

    MaxHeap() {
        ar = new ArrayList<>();
        ar.add(0); // Dummy value
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        new MaxHeap();
        while (t-- > 0) {
            String[] in = reader.readLine().trim().split(" ");
            switch (in[0]) {
                case "insert":
                    insert(Integer.parseInt(in[1]));
                    break;
                case "getMin":
                    writer.write(ar.size() != 1 ? String.valueOf(getMin()) : "Empty");
                    writer.newLine();
                    break;
                case "delMin":
                    delMin();
                    break;
            }
        }
        writer.flush();
    }

    public static void insert(int x) {
        ar.add(x);
        int pos = ar.size() - 1;
        while (pos != 1 && ar.get(pos) > ar.get(pos / 2)) { // Here is the difference from minHeap
            swap(pos / 2, pos);
            pos = pos / 2;
        }
    }

    public static void delMin() {
        if (ar.size() == 1)
            return;
        int pos = ar.size() - 1;
        ar.set(1, ar.get(pos)); // Replace first element with leftmost node
        ar.remove(pos); //remove leftmost node
        maxHeap(1);
    }


    private static void maxHeap(int pos) {
        int left = 2 * pos;
        int right = 2 * pos + 1;
        int large = pos; // Largest child among two children of parent.
        if (left < ar.size() && ar.get(left) > ar.get(pos)) {
            large = left;
        }
        if (right < ar.size() && ar.get(right) > ar.get(large)) {
            large = right;
        }
        // Replace if the parent is smaller than it's child until tree satisfies the property(Parent >= child)
        if (large != pos) {
            swap(pos, large);
            maxHeap(large);
        }
    }

    private static void swap(int pos, int s) {
        int temp = ar.get(pos);
        ar.set(pos, ar.get(s));
        ar.set(s, temp);
    }

    public static int getMin() {
        return ar.get(1);
    }
}
