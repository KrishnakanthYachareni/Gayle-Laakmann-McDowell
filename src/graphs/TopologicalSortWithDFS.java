package graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortWithDFS {

    /**
     * Performs Topological Sorting using Kahn's Algorithm (DFS approach).
     *
     * <p><b>What is Topological Sorting?</b>
     * Topological Sorting is a linear ordering of vertices in a Directed Acyclic Graph (DAG),
     * such that for every directed edge U → V, vertex U appears before V.
     * </p>
     * <p>
     * Performs Topological Sorting using DFS approach.
     *
     * <p><b>Solution Approach:</b>
     * 1. Represent the graph using an adjacency list.
     * 2. Use a boolean array to track visited nodes.
     * 3. Perform Depth-First Search (DFS) for each unvisited node:
     * - Mark the node as visited.
     * - Recursively visit all its adjacent nodes.
     * - Push the node onto a stack after all its neighbors are processed.
     * 4. After DFS completes for all nodes, print the stack contents as the topological order.
     * </p>
     */
        public static void topologicalSort(Map<Integer, List<Integer>> graph, int V) {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(graph, i, visited, stack);
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }

        /**
         * Helper method for DFS traversal to process nodes in topological order.
         */
        private static void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited, Stack<Integer> stack) {
            visited[node] = true;

            for (int nbr : graph.getOrDefault(node, List.of())) {
                if (!visited[nbr]) {
                    dfs(graph, nbr, visited, stack);
                }
            }
            stack.push(node);
        }

    public static void main(String[] args) {
        int vertices = 6;
        var sampleGraph = new GraphNode(vertices, true);
        // Adding edges
        sampleGraph.addEdge(0, 2);
        sampleGraph.addEdge(1, 2);
        sampleGraph.addEdge(1, 4);
        sampleGraph.addEdge(4, 5);
        sampleGraph.addEdge(3, 5);
        sampleGraph.addEdge(2, 3);

//        topologicalSort(sampleGraph.getGraph(), vertices);

        Map<String, String> map = new HashMap<>();
        map.put("123", "432");
        map.put("123", "431");
        System.out.println(map);
    }
}
