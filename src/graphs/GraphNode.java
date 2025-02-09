package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private final List<List<Integer>> graph;
    private final boolean isUndirected;

    public GraphNode(int vertices, boolean isUndirected) {
        this.isUndirected = isUndirected;
        this.graph = new ArrayList<>();
        while (vertices-- >= 0) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2) {
        this.graph.get(v1).add(v2);
        if (isUndirected) {
            this.graph.get(v2).add(v1);
        }
    }

    public List<List<Integer>> getGraph() {
        return this.graph;
    }

    public boolean isUndirected() {
        return this.isUndirected;
    }

    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Vertex : " + i + "--> " + graph.get(i));
        }
    }
}
