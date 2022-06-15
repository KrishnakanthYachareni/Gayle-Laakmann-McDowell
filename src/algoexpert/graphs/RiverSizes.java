package algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                traverseNode(i, j, matrix, visited, sizes);
            }
        }

        return sizes;
    }

    // Apply DFS algo
    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {

        int currentRiverSize = 0;
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[]{i, j});


        while (!nodesToExplore.isEmpty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            currentRiverSize++;

            List<Integer[]> unvisitedNeighbours = getUnvisitedNeighbors(i, j, matrix, visited);
            for (Integer[] neighbor : unvisitedNeighbours) {
                nodesToExplore.push(neighbor);
            }
        }
        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNeighbors.add(new Integer[]{i - 1, j});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            unvisitedNeighbors.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNeighbors.add(new Integer[]{i, j - 1});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            unvisitedNeighbors.add(new Integer[]{i, j + 1});
        }
        return unvisitedNeighbors;
    }
}
