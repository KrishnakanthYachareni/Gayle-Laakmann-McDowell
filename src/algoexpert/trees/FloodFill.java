package algoexpert.trees;

public class FloodFill {


    // DFS approach using recursion TC = O(N), SC = O(N)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        if (color != newColor)
            dfs(image, sr, sc, color, newColor);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length
                || image[row][col] != color)
            return;

        image[row][col] = newColor;

        dfs(image, row - 1, col, color, newColor);
        dfs(image, row, col + 1, color, newColor);
        dfs(image, row + 1, col, color, newColor);
        dfs(image, row, col - 1, color, newColor);
    }


    // DFS approach using iterative TC = O(N), SC = O(N)
    /*public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null)
            return null;

        int startPixel = image[sr][sc];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{sr, sc});

        while (!stack.isEmpty()) {
            int[] currentNode = stack.pop();
            sr = currentNode[0];
            sc = currentNode[1];

            if (image[sr][sc] == color)
                continue;

            image[sr][sc] = color;

            List<int[]> neighbors = getNeighbors(image, sr, sc);
            for (int[] node : neighbors) {
                if (image[node[0]][node[1]] == startPixel)
                    stack.push(node);
            }
        }
        return image;
    }

    private List<int[]> getNeighbors(int[][] image, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        int[] rowOffsets = new int[]{-1, 0, 1, 0};
        int[] colOffsets = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length)
                continue;

            neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }*/
}
