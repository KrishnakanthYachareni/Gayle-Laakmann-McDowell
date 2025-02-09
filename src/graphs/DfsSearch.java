package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsSearch {


    /*public static void bfsBasicSearch(List<List<Integer>> graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println("Node Visited: " + currentNode);

            for (int neighbour : graph.get(currentNode)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }*/

    /*
     *  Finding Shortest Path (SSSP: Single Source Shortest Path)
     *  1. distance(node) = distance(parent) + 1; -> to find the distance between nodes.
     *  2. parent[node] = P; -> To backTrack to the parent
     *
     */
    public static void bfsShortestPath(List<List<Integer>> graph, int source, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;

        int[] distance = new int[graph.size()];
        distance[source] = 0;

        int[] parent = new int[graph.size()];
        parent[source] = source;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbour : graph.get(currentNode)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true; // Mark as visited

                    distance[neighbour] = distance[currentNode] + 1; // Calculate distance of node
                    parent[neighbour] = currentNode; // Parent Node
                }
            }
        }

        // Print the shortest distance
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Shortest dest to " + i + " is " + distance[i]);
        }

        // Print the path from any destination
        System.out.print("Shortest Path from Dest is: ");
        while (source != dest) {
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

        bfsShortestPath(graph.getGraph(), 1, 6);
    }

}
