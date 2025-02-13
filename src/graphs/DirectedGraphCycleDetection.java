package graphs;

import java.util.List;
import java.util.Map;

public class DirectedGraphCycleDetection {

    /**
     * To detect a cycle in a directed graph,
     * 1. use Depth-First Search (DFS) with a recursion stack.
     * 2. Start DFS from each unvisited node, marking it as visited and adding it to the recursion stack.
     * 3. If you encounter a node that is already in the stack, a cycle exists (back edge detected).
     * 4. After exploring all neighbors, remove the node from the stack (backtracking).
     * 5. If DFS completes without finding a back edge, the graph has no cycle.
     * <p>
     * Quick Tip: If a node appears again in the recursion stack → Cycle detected! ✅
     *
     * @param vertices The total number of vertices in the graph.
     */
    public static boolean hasCycleInGraph(Map<Integer, List<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean[] stack = new boolean[vertices];

        // Check every vertex to handle disconnected components
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Performs a Depth-First Search (DFS) to detect cycles in a directed graph.
     * It maintains a recursion stack to detect back edges indicating a cycle.
     *
     * @param graph    The adjacency list representation of the graph.
     * @param currNode The current node being visited.
     * @param visited  Boolean array tracking visited nodes.
     * @param stack    Boolean array tracking the nodes in the current recursion stack.
     */
    private static boolean dfs(Map<Integer, List<Integer>> graph, int currNode, boolean[] visited, boolean[] stack) {
        visited[currNode] = true;
        stack[currNode] = true;

        for (int neighbor : graph.getOrDefault(currNode, List.of())) {
            if (stack[neighbor]) { // Cycle detected (back edge)
                return true;
            } else if (!visited[neighbor]) { // Visit unvisited nodes
                if (dfs(graph, neighbor, visited, stack)) {
                    return true;
                }
            }
        }
        // Backtracking: Remove the node from recursion stack
        stack[currNode] = false;
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        var sampleGraph = new GraphNode(vertices, true);
        // Adding edges
        sampleGraph.addEdge(0, 1);
        sampleGraph.addEdge(1, 2);
        sampleGraph.addEdge(2, 3);
        sampleGraph.addEdge(0, 4);
        sampleGraph.addEdge(0, 5);
        sampleGraph.addEdge(5, 4);
        sampleGraph.addEdge(3, 0);

        System.out.println(hasCycleInGraph(sampleGraph.getGraph(), vertices));
    }
}
