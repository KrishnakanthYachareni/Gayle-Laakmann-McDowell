package graphs;

import java.util.List;
import java.util.Map;

/*
    Bi-Partite with undirected graph
 */
public class BiPartiteGraph {

    /**
     * Checks if a given undirected graph is bipartite.
     * A bipartite graph is one where we can divide vertices into two sets
     * such that no two adjacent vertices belong to the same set.
     *
     * @param graph The adjacency list representation of the graph.
     * @param V     The number of vertices in the graph.
     */
    public static boolean isBipartiteGraph(Map<Integer, List<Integer>> graph, int V) {
        int[] visited = new int[V]; // 0 -> Not visited, 1 -> Color-1, 2 -> Color-2.

        // Start DFS from the first node
        boolean result = dfsHelper(graph, 0, visited, -1, 1);

        // Optional: Print node colors
        for (int i = 0; i < V; i++) {
            System.out.println("Node: " + i + " Color: " + visited[i]);
        }

        return result;
    }

    /**
     * What is a Bipartite Graph?
     * A bipartite graph is a graph whose vertices can be divided into two sets
     * such that no two vertices in the same set are adjacent.
     * </p>
     *
     * <p><b>Solution Approach:</b>
     * 1. Use Depth-First Search (DFS) to traverse the graph.
     * 2. Assign alternate colors (1 and 2) to adjacent nodes.
     * 3. If any two adjacent nodes have the same color, return false.
     * 4. Otherwise, after all traversals, return true.
     * </p>
     *
     * @param graph The adjacency list representation of the graph.
     * @param V     The number of vertices in the graph.
     */
    private static boolean dfsHelper(Map<Integer, List<Integer>> graph, int curNode, int[] visited, int parent, int color) {
        // / 0 -> Visited, 1 -> Visited color-1, 2 -> visited color-2. Instead of making boolean and int arrays separately for tracking visited nodes and color for each node. Using one int array.
        visited[curNode] = color;

        for (int nbr : graph.getOrDefault(curNode, List.of())) {
            if (visited[nbr] == 0) { // If the neighbor is not visited
                boolean subProb = dfsHelper(graph, nbr, visited, curNode, 3 - color); // Alternate color (1 -> 2, 2 -> 1) | To add the alternate color for every recursive call subtract from 3
                if (!subProb) {
                    return false; // If a conflict is found, return false
                }
            } else if (curNode != parent && visited[nbr] == color) {
                // If the neighbor is already visited and has the same color, it's not bipartite
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int vertices = 4;
        var sampleGraph = new GraphNode(vertices, false);
        // Adding edges
        sampleGraph.addEdge(0, 1);
        sampleGraph.addEdge(0, 2);
        sampleGraph.addEdge(1, 3);
        sampleGraph.addEdge(2, 3);
        sampleGraph.addEdge(2, 3);

        var result = isBipartiteGraph(sampleGraph.getGraph(), vertices);
        System.out.println("BiPartite Graph: " + result);
    }
}
