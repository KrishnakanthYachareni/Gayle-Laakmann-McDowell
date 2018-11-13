/*
 * Copyright (c) 2018 Krishnakanth Yachareni. All rights reserved.
 */

package chapter1.string;

/**
 * @author Krishnakanth Yachareni
 * @since 13-11-2018
 * <p>
 * Given an image represented by an N x N matrix, where each pixel in the image is the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * </p>
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int n = 3;
        int[][] input = new int[n][n];
        int inc = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = inc++;
            }
        }
        System.out.println("Before Rotate");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
        boolean res = rotateMatrix(input);
        System.out.println(res);
        System.out.println("Rotated Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[j][i]);
            }
            System.out.println();
        }
    }

    private static boolean rotateMatrix(int[][] matrix) {
        // Not a Square.
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // Save Top

                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];

                // Bottom  -> Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;
            }
        }
        return true;
    }
}
