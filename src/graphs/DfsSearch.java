package graphs;

import java.util.List;
import java.util.Stack;

public class DfsSearch {


   /* // DFS using Iteration
    public static void dfsBasicSearchIteration(List<List<Integer>> graph, int source) {
        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            System.out.println("Current Node: " + currentNode);

            for (int neighbour : graph.get(currentNode)) {
                if (!visited[neighbour]) {
                    stack.add(neighbour);
                    visited[neighbour] = true; // Mark visited
                }
            }
        }
    }
*/

    /*// DFS using recursion
    public static void dfsBasicSearchRecursive(List<List<Integer>> graph, int source) {
        boolean[] visited = new boolean[graph.size()];

        dfsHelper(graph, source, visited);
    }

    private static void dfsHelper(List<List<Integer>> graph, int currentNode, boolean[] visited) {
        visited[currentNode] = true;
        System.out.println("Current Node: " + currentNode);

        for (int neighbour : graph.get(currentNode)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                dfsHelper(graph, neighbour, visited);
            }
        }
    }*/

    /*
     *  Finding Shortest Path (SSSP: Single Source Shortest Path)
     *  1. distance(node) = distance(parent) + 1; -> to find the distance between nodes.
     *  2. parent[node] = P; -> To backTrack to the parent
     *
     */
    public static void dfsShortestPath(List<List<Integer>> graph, int source, int dest) {
        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;

        int[] distance = new int[graph.size()];
        distance[source] = 0;

        int[] parent = new int[graph.size()];
        parent[source] = source;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            for (int neighbour : graph.get(currentNode)) {
                if (!visited[neighbour]) {
                    stack.add(neighbour);
                    visited[neighbour] = true; // Mark visited

                    distance[neighbour] = distance[currentNode] + 1;
                    parent[neighbour] = currentNode;
                }
            }
        }

        // Shortest path from the source
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Shortest path to the " + i + " is " + distance[i]);
        }

        // Print the path from source to destination node
        while (dest != source) {
            System.out.print(dest + " --> ");
            dest = parent[dest];
        }
        System.out.print(source);
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(6, true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        // graph.printGraph();

        dfsShortestPath(graph.getGraph(), 1, 6);
    }

}
