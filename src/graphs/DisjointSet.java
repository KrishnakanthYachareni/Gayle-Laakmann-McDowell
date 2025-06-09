package graphs;

public class DisjointSet {
    private final int[] parent;
    private final int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Each node is its own parent initially
            rank[i] = 0;   // Initial rank is 0
        }
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union by rank
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false; // Same set, cycle detected
        }

        // Union by rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}

class GraphCycleDetection {
    // Function to detect cycle in an undirected graph
    public boolean hasCycle(int vertices, int[][] edges) {
        DisjointSet ds = new DisjointSet(vertices);

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If u and v are already in the same set, adding this edge creates a cycle
            if (!ds.union(u, v)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        GraphCycleDetection gcd = new GraphCycleDetection();

        // Test Case 1: Graph with a cycle
        int vertices1 = 4;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println("Graph 1 has cycle: " + gcd.hasCycle(vertices1, edges1)); // Expected: true

        // Test Case 2: Graph without a cycle
        int vertices2 = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Graph 2 has cycle: " + gcd.hasCycle(vertices2, edges2)); // Expected: false
    }
}
