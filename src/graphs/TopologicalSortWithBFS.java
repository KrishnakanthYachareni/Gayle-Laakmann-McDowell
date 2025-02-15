package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortWithBFS {

    /**
     * Performs Topological Sorting using Kahn's Algorithm (BFS approach).
     *
     * <p><b>What is Topological Sorting?</b>
     * Topological Sorting is a linear ordering of vertices in a Directed Acyclic Graph (DAG),
     * such that for every directed edge U → V, vertex U appears before V.
     * </p>
     *
     * <p><b>Solution Approach:</b>
     * 1. Compute the in-degree of each node (number of incoming edges).
     * 2. Add all nodes with in-degree 0 to a queue.
     * 3. Process nodes from the queue:
     * - Print or store the node.
     * - Reduce the in-degree of its neighbors.
     * - If a neighbor's in-degree becomes 0, add it to the queue.
     * 4. Repeat until the queue is empty.
     * </p>
     *
     * @param graph The adjacency list representation of the directed graph.
     * @param V     The number of vertices in the graph.
     */
    public static void topologicalSort(Map<Integer, List<Integer>> graph, int V) {

        // Find the In-degree of each node
        int[] indegree = new int[V];
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int nbr : entry.getValue()) {
                indegree[nbr]++;
            }
        }

        // Initialize BFS Queue with whose nodes indegree are 0.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Traverse BFS
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            System.out.print(curNode + " ");

            for (int nbr : graph.getOrDefault(curNode, List.of())) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }
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

        topologicalSort(sampleGraph.getGraph(), vertices);
    }
}
