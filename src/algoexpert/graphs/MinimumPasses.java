package algoexpert.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumPasses {

    public static void main(String[] args) {

    }

    // Linear time and space complexities
    public int minimumPassesOfMatrix(int[][] matrix) {
        int passes = convertNegatives(matrix);

        return !containsNegative(matrix) ? passes - 1 : -1;
    }

    private static int convertNegatives(int[][] matrix) {
        Queue<int[]> queue = getAllPositivePositions(matrix);
        int passes = 0;

        while (!queue.isEmpty()) {

            int currentSize = queue.size();
            while (currentSize > 0) {
                int[] vals = queue.poll();
                int currentRow = vals[0];
                int currentCol = vals[1];

                List<int[]> adjacentPositions = getAdjacentPositions(currentRow, currentCol, matrix);

                for (int[] position : adjacentPositions) {
                    int row = position[0];
                    int col = position[1];

                    if (matrix[row][col] < 0) {
                        matrix[row][col] *= -1;
                        queue.add(new int[]{row, col});
                    }
                }
                currentSize--;
            }
            passes++;
        }

        return passes;
    }

    private static Queue<int[]> getAllPositivePositions(int[][] matrix) {
        Queue<int[]> positivePositions = new LinkedList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int value = matrix[row][col];
                if (value > 0)
                    positivePositions.add(new int[]{row, col});
            }
        }
        return positivePositions;
    }

    private static List<int[]> getAdjacentPositions(int row, int col, int[][] matrix) {
        List<int[]> adjacentPositions = new ArrayList<>();

        if (row > 0) // UP
            adjacentPositions.add(new int[]{row - 1, col});

        if (row < matrix.length - 1) // DOWN
            adjacentPositions.add(new int[]{row + 1, col});

        if (col > 0) // LEFT
            adjacentPositions.add(new int[]{row, col - 1});

        if (col < matrix[0].length - 1) // RIGHT
            adjacentPositions.add(new int[]{row, col + 1});

        return adjacentPositions;
    }

    private static boolean containsNegative(int[][] matrix) {
        for (int[] row : matrix)
            for (int value : row)
                if (value < 0)
                    return true;

        return false;
    }
}
