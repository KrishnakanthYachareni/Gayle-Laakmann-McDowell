package algoexpert.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfIslands {

    /*
        Easy Approach:
        ------------
        Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers
        a Depth First Search. During DFS, every visited node should be set as '0' to mark as visited node.
        Count the number of root nodes that trigger DFS, this number would be the number of islands since
        each DFS starting at some root identifies an island.

        TC = O(N), SC = O(N)
     */
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }

   /* // Same complexity but iterative and can get sizes of islands TC = O(N), SC = O(N)
    public int numIslands(char[][] grid) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isVisited[i][j])
                    continue;

                traverseNodes(grid, isVisited, i, j, sizes);
            }
        }
        return sizes.size();
    }

    private static void traverseNodes(char[][] grid, boolean[][] isVisited, int i, int j, List<Integer> sizes) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{i, j});

        int currentSize = 0;

        while (!stack.isEmpty()) {
            Integer[] currentNode = stack.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (isVisited[i][j])
                continue;

            isVisited[i][j] = true;

            if (grid[i][j] == '0')
                continue;

            currentSize++;
            List<Integer[]> unvisitedNodes = getUnvisitedNodes(grid, i, j, isVisited);

            for (Integer[] node: unvisitedNodes)
                stack.push(node);
        }
        if (currentSize > 0)
            sizes.add(currentSize);
    }

    private static List<Integer[]> getUnvisitedNodes(char[][] grid, int i, int j, boolean[][] isVisited) {
        List<Integer[]> unvisitedNodes = new ArrayList<>();

        if (i > 0 && !isVisited[i - 1][j])
            unvisitedNodes.add(new Integer[]{i - 1, j});

        if (i < grid.length - 1 && !isVisited[i + 1][j])
            unvisitedNodes.add(new Integer[]{i + 1, j});

        if (j > 0 && !isVisited[i][j - 1])
            unvisitedNodes.add(new Integer[]{i, j - 1});

        if (j < grid[0].length - 1 && !isVisited[i][j + 1])
            unvisitedNodes.add(new Integer[]{i, j + 1});

        return unvisitedNodes;
    }*/
}
