package algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveIslands {
    /*
     * TC, SC = matrix length
     * First check all the borders row, cols having 1, if yes from there apply DFS to mark
     * the connected island with 2 or any other number.
     * Once we identify traverse inner matrix (Means except for the border rows, cols) and replace all the 1's with 0's
     * and 2's with 1's
     */
    public int[][] removeIslands(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                boolean isRowBoarder = row == 0 || row == matrix.length - 1;
                boolean isColBoarder = col == 0 || col == matrix[0].length - 1;
                boolean isBoarder = isRowBoarder || isColBoarder;

                if (!isBoarder)
                    continue;

                if (matrix[row][col] != 1)
                    continue;

                connectToAllBorderIslands(matrix, row, col);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int color = matrix[row][col];
                if (color == 1)
                    matrix[row][col] = 0;
                else if (color == 2)
                    matrix[row][col] = 1;
            }
        }
        return matrix;
    }

    private static void connectToAllBorderIslands(int[][] matrix, int row, int col) {
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[]{row, col});

        while (!nodesToExplore.isEmpty()) {
            Integer[] currentNode = nodesToExplore.pop();
            row = currentNode[0];
            col = currentNode[1];

            if (matrix[row][col] != 1) // Add only the 1's which are connected.
                continue;

            if (matrix[row][col] == 2) // avoid revisiting
                continue;

            matrix[row][col] = 2;

            List<Integer[]> unexploredNodes = getUnexploredNodes(matrix, row, col);
            nodesToExplore.addAll(unexploredNodes);
        }
    }

    private static List<Integer[]> getUnexploredNodes(int[][] matrix, int row, int col) {
        List<Integer[]> unvisitedNodes = new ArrayList<>();
        if (row > 0 && matrix[row - 1][col] != 2)
            unvisitedNodes.add(new Integer[]{row - 1, col});

        if (row < matrix.length - 1 && matrix[row + 1][col] != 2)
            unvisitedNodes.add(new Integer[]{row + 1, col});

        if (col > 0 && matrix[row][col - 1] != 2)
            unvisitedNodes.add(new Integer[]{row, col - 1});

        if (col < matrix[0].length - 1 && matrix[row][col + 1] != 2)
            unvisitedNodes.add(new Integer[]{row, col + 1});

        return unvisitedNodes;
    }
}
