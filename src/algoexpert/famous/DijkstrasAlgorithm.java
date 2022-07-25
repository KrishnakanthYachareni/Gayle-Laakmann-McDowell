package algoexpert.famous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 *
 * 1. Djikstra's: finds the smallest cost path from a source node to every other node in the graph,
 *    except if there is a negative weight edge. (Dijkstra's can be transformed easily into the A* algorithm by just
 *    changing it to stop once its found the target node and adding heuristics.)
 *
 * 2. Bellman-Ford: does the same as Dijkstra's, but is slower. But it can handle negative weight edges.
 *
 * 3. Floyd-Warshall: finds the cost of the smallest cost path from each node to every other node.
 *    (It returns a numeric matrix.) It is far slower than either Djikstra's or Bellman-Ford.
 *    it just reports a meaningless negative number for the cost of some node to itself when a negative cycle occurs.
 *
 *
 * standard rule of thumb that is followed for solving the shortest path problems is that we mostly use
 * Breadth-first search for unweighted graphs and use Dijkstra's algorithm for weighted graphs.
 * An implied condition to apply the Dijkstra's algorithm is that the weights of the graph must be positive.
 * If the graph has negative weights and can have negative weighted cycles, we would have to employ another
 * algorithm called the Bellman Ford's.
 *
 * Interviewer to ask on graph question:
 *  1. Graph has negative weights?
 *  2. Cycle?
 *  4. Self loops?
 */
public class DijkstrasAlgorithm {

    // TC = O (V + E) * log (V), SC = O(V)
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int totalVertices = edges.length;
        int[] minDistances = new int[totalVertices];
        Arrays.fill(minDistances, -1);
        minDistances[start] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        minHeap.add(new Pair(start, 0)); // start vertex distance is 0

        Set<Integer> visited = new HashSet<>();

        while (visited.size() < totalVertices && !minHeap.isEmpty()) {
            Pair nextNode = minHeap.poll(); // Gives us the minimum distance node that is not visited already

            if (visited.contains(nextNode.id)) // Already visited
                continue;

            visited.add(nextNode.id);
            minDistances[nextNode.id] = nextNode.distance;
            for (int[] edge : edges[nextNode.id]) {
                if (!visited.contains(edge[0])) {
                    minHeap.add(new Pair(edge[0], edge[1] + nextNode.distance));
                }
            }
        }
        return minDistances;
    }

    static class Pair {
        int id; // Vertex Id
        int distance; // Total minimum distance so far to this vertex

        public Pair(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
