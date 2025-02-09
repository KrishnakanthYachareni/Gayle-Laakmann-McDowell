package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleGraph {

    private final Map<Integer, List<Integer>> graph;

    public SampleGraph() {
        this.graph = new HashMap<>();
    }

    // Directed Graph
    public void addEdge(int v1, int v2) {
        this.graph.putIfAbsent(v1, new ArrayList<>());
        this.graph.get(v1).add(v2);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + "--> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        var sampleGraph = new SampleGraph();
        // Adding edges
        sampleGraph.addEdge(2, 3);
        sampleGraph.addEdge(2, 5);
        sampleGraph.addEdge(5, 3);

        // Print the graph
        sampleGraph.printGraph();
    }

}
