package algoexpert.graphs;

public class CycleInGraph {

    private static final int WHITE = 0; // Unvisited
    private static final int GREY = 1; // Visited and in the current recursive stack
    private static final int BLACK = 2; // Finished. (Visited and not in the stack)

    //  TC = O(v + e) | SC = O(v)
    public static boolean cycleInGraph(int[][] edges) {
        int numberOfNodes = edges.length;
        int[] colors = new int[numberOfNodes]; // By default, 0 (WHITE)

        for (int i = 0; i < numberOfNodes; i++) {

            if (colors[i] != WHITE) // If already visited/finished.
                continue;

            boolean isCycle = traverseAndMarkColor(edges, i, colors);

            if (isCycle)
                return true;
        }
        return false;
    }

    private static boolean traverseAndMarkColor(int[][] edges, int node, int[] colors) {
        if (colors[node] == GREY) // Back Edge forms a cycle
            return true;

        colors[node] = GREY;
        int[] neighbors = edges[node];

        for (int neighbor : neighbors) {
            if (colors[neighbor] == BLACK) // If finished
                continue;

            boolean isCycle = traverseAndMarkColor(edges, neighbor, colors);
            if (isCycle)
                return true;
        }
        colors[node] = BLACK;
        return false;
    }
}
