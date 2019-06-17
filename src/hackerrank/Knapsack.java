/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank;

public class Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int capacity = 50;
        System.out.println(knapsack(capacity, wt, val, 3));
    }

    private static int knapsack(int capacity, int[] weights, int[] values, int totalItems) {
        if (0 == capacity || 0 == totalItems) {
            return 0;
        }
        if (weights[totalItems - 1] > capacity) {
            return knapsack(capacity, weights, values, totalItems - 1);
        }
        return max(values[totalItems - 1] + knapsack(capacity - weights[totalItems - 1], weights, values, totalItems - 1), knapsack(capacity, weights, values, totalItems - 1));
    }

    private static int max(int a, int b) {
        return -1;
    }
}
