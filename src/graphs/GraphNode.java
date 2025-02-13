package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {

    private final Map<Integer, List<Integer>> graph;
    private final boolean isDirected;

    public GraphNode(int vertices, boolean isDirected) {
        this.graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            this.graph.put(i, new ArrayList<>());
        }
        this.isDirected = isDirected;
    }

    // Directed Graph
    public void addEdge(int v1, int v2) {
        if (isDirected) {
            this.graph.get(v1).add(v2);
        } else {
            this.graph.get(v1).add(v2);
            this.graph.get(v2).add(v1);
        }
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + "--> " + entry.getValue());
        }
    }

    public Map<Integer, List<Integer>> getGraph() {
        return graph;
    }

    public static void main(String[] args) {
        var sampleGraph = new GraphNode(3, true);
        // Adding edges
        sampleGraph.addEdge(2, 3);
        sampleGraph.addEdge(2, 5);
        sampleGraph.addEdge(5, 3);

        // Print the graph
        sampleGraph.printGraph();
    }

}
