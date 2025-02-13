package graphs;

import java.util.List;
import java.util.Map;

public class UnDirectedGraphCycleDetection {

    /**
     * To detect a cycle in an undirected graph,
     * 1. Use Depth-First Search (DFS) while keeping track of the parent node.
     * 2. Start DFS from each unvisited node and explore its neighbors.
     * 3. If a neighbor is already visited and is not the parent, a cycle exists.
     * 4. Otherwise, continue DFS for unvisited neighbors.
     * 5. If DFS completes without finding such a case, the graph has no cycle.
     * <p>
     * Quick Tip: If we revisit a node that isn’t our parent → Cycle detected! ✅
     */
    public static boolean hasCycleInGraph(Map<Integer, List<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];

        // Check every vertex to handle disconnected components
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Performs a Depth-First Search (DFS) to detect cycles in an undirected graph.
     * Unlike in directed graphs, we need to track the parent node to avoid false cycle detection.
     *
     * @param graph    The adjacency list representation of the graph.
     * @param currNode The current node being visited.
     * @param parent   The parent node from which the current node was reached.
     * @param visited  Boolean array tracking visited nodes.
     * @return {@code true} if a cycle is found, otherwise {@code false}.
     */
    private static boolean dfs(Map<Integer, List<Integer>> graph, int currNode, int parent, boolean[] visited) {
        visited[currNode] = true;

        for (int neighbor : graph.getOrDefault(currNode, List.of())) {
            if (!visited[neighbor]) { // Visit unvisited nodes
                if (dfs(graph, neighbor, currNode, visited)) {
                    return true;
                }
            } else if (neighbor != parent) { // If visited and not parent, cycle detected
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        var sampleGraph = new GraphNode(vertices, false);
        // Adding edges
        sampleGraph.addEdge(0, 1);
        sampleGraph.addEdge(1, 2);
        sampleGraph.addEdge(2, 3);
        sampleGraph.addEdge(0, 4);
        sampleGraph.addEdge(0, 5);
        sampleGraph.addEdge(5, 4);

        System.out.println(hasCycleInGraph(sampleGraph.getGraph(), vertices));
    }
}
