/*
 * Copyright (c) 2018 Krishnakanth Yachareni. All rights reserved.
 */
package com.book.strings;

/**
 * @author Krishnakanth Yachareni
 * @since 14-11-2018
 * <p>
 * Write an algorithm such that if an element if an element in an M x N matrix is 0. it's entire row and column set
 * zero.
 * <p>
 * Space Complexity: O(MN) M = row, N = column
 * </p>
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] input = new int[m][n];
        int inc = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = inc++;
            }
        }
        input[0][0] = 0;
        System.out.println("Before");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
        boolean res = zeroMatrix(input);
        System.out.println(res);
        System.out.println("Zero Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean zeroMatrix(int[][] input) {
        boolean[] row = new boolean[input.length];
        boolean[] column = new boolean[input[0].length];
        // Find the element with 0 & their indexes.
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        // Nullify Rows
        for (int i = 0; i < input.length; i++) {
            if (row[i]) {
                nullifyRow(i, input);
            }
        }
        // Nullify Column
        for (int i = 0; i < input[0].length; i++) {
            if (column[i]) {
                nullifyColumn(i, input);
            }
        }
        return true;
    }

    private static void nullifyRow(int row, int[][] input) {
        for (int j = 0; j < input.length; j++) {
            input[row][j] = 0;
        }
    }

    private static void nullifyColumn(int column, int[][] input) {
        for (int i = 0; i < input[0].length; i++) {
            input[i][column] = 0;
        }
    }
}
