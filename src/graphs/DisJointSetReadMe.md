# Disjoint Set (Union-Find) Approach and Usage

## Overview
The **Disjoint Set** (also known as **Union-Find**) data structure is used to manage a collection of non-overlapping sets. It efficiently supports two primary operations:
- **Find**: Determines which set an element belongs to by finding its representative (root).
- **Union**: Merges two sets into a single set.

With optimizations like **union by rank** and **path compression**, the Disjoint Set achieves near-constant time complexity for these operations, making it ideal for problems involving grouping or connectivity.

## Key Concepts
- **Sets**: Each element belongs to exactly one set, represented by a unique root node.
- **Parent Array**: Tracks the parent of each element, forming a forest of trees where each tree represents a set.
- **Optimizations**:
    - **Union by Rank**: When merging sets, attach the shorter tree to the root of the taller tree to keep the tree balanced.
    - **Path Compression**: During a `find` operation, make each node point directly to the root to flatten the tree, speeding up future operations.

## Time and Space Complexity
- **Time Complexity**:
    - Initialization: O(n), where n is the number of elements.
    - Find: O(α(n)) amortized, where α is the inverse Ackermann function (effectively constant for practical purposes).
    - Union: O(α(n)) amortized.
- **Space Complexity**: O(n) for the parent and rank arrays.

## Approach
The Disjoint Set operates as follows:
1. **Initialization**:
    - Create a parent array where each element is its own parent (i.e., each element is a singleton set).
    - Initialize a rank array to track tree heights (optional, for union by rank).
2. **Find Operation**:
    - Recursively traverse the parent pointers until the root is found (where `parent[x] == x`).
    - Apply path compression by updating each node’s parent to point directly to the root.
3. **Union Operation**:
    - Find the roots of the two elements’ sets.
    - If the roots are the same, the elements are already in the same set (no merge needed).
    - Otherwise, merge the sets by making one root the parent of the other, using rank to minimize tree height.
4. **Connected Query** (optional):
    - Check if two elements are in the same set by comparing their roots (via `find`).

## Implementation
Below is a Java implementation of Disjoint Set with union by rank and path compression:

```java
class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Each element is its own parent
            rank[i] = 0;   // Initial rank is 0
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false; // Already in the same set
        }
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

    public boolean connected(int x, y) {
        return find(x) == find(y);
    }
}
```

## Usage
The Disjoint Set is widely used in algorithms and applications involving grouping, connectivity, or partitioning. Below are common use cases with examples:

### 1. Cycle Detection in Undirected Graphs
- **Problem**: Detect if an undirected graph contains a cycle.
- **Approach**:
    - Initialize a Disjoint Set for all vertices.
    - For each edge `{u, v}`:
        - If `find(u) == find(v)`, the vertices are already in the same set, so adding the edge creates a cycle.
        - Otherwise, call `union(u, v)` to merge the sets.
- **Example**:
    - Graph with vertices `0, 1, 2, 3` and edges `{{0,1}, {1,2}, {2,3}, {3,0}}`.
    - The edge `{3,0}` causes `find(3) == find(0)`, indicating a cycle.
- **Code Snippet**:
  ```java
  public boolean hasCycle(int vertices, int[][] edges) {
      DisjointSet ds = new DisjointSet(vertices);
      for (int[] edge : edges) {
          int u = edge[0];
          int v = edge[1];
          if (!ds.union(u, v)) {
              return true; // Cycle detected
          }
      }
      return false;
  }
  ```

### 2. Kruskal’s Algorithm for Minimum Spanning Tree (MST)
- **Problem**: Find the MST of a weighted undirected graph.
- **Approach**:
    - Sort edges by weight.
    - Initialize a Disjoint Set for all vertices.
    - Iterate through sorted edges, adding an edge to the MST if it connects different sets (checked via `find` and merged via `union`).
- **Example**:
    - Graph with edges `{{0,1,4}, {1,2,3}, {2,3,1}, {0,3,2}}` (format: `{u,v,weight}`).
    - Select edges `{2,3,1}, {0,3,2}, {1,2,3}` to form the MST (weight = 6).
- **Relevance**: Used in network design (e.g., minimizing cable length in a network).

### 3. Connected Components in a Graph
- **Problem**: Count the number of connected components in an undirected graph.
- **Approach**:
    - Initialize a Disjoint Set and track the number of sets.
    - For each edge, call `union` to merge sets, decrementing the count when sets are merged.
    - The final count is the number of components.
- **Example**:
    - Graph with vertices `0, 1, 2, 3, 4` and edges `{{0,1}, {1,2}, {3,4}}`.
    - Result: 2 components (`{0,1,2}`, `{3,4}`).

### 4. Friend Circles or Social Network Grouping
- **Problem**: Group people into friend circles based on friendships.
- **Approach**:
    - Treat people as vertices and friendships as edges.
    - Use Disjoint Set to merge friend groups and query if two people are in the same circle.
- **Example**:
    - Friendships: `{{0,1}, {1,2}, {3,4}}`.
    - Query: Are 0 and 2 friends? `ds.connected(0, 2)` returns `true`.

### 5. Image Processing
- **Problem**: Group connected pixels in an image (e.g., flood fill or region labeling).
- **Approach**:
    - Treat pixels as vertices and adjacent pixels as edges.
    - Use Disjoint Set to merge connected regions.
- **Example**:
    - In a binary image, group all 1s that are 4-connected (up, down, left, right).

## Advantages
- **Efficiency**: Near-constant time per operation with optimizations.
- **Simplicity**: Easy to implement and adapt for various problems.
- **Versatility**: Applicable to graphs, networks, and partitioning tasks.

## Limitations
- **Undirected Graphs**: Standard Disjoint Set is designed for undirected graphs. Directed graph cycle detection requires other approaches (e.g., DFS).
- **Dynamic Updates**: Adding/removing edges dynamically may require additional logic.
- **Memory**: Requires O(n) extra space for parent and rank arrays.

## Practical Tips
- **Always Use Optimizations**: Union by rank and path compression are critical for performance.
- **Handle Edge Cases**: Validate inputs (e.g., out-of-bounds vertices, self-loops).
- **Practice Problems**: Solve LeetCode problems like:
    - #684: Redundant Connection (cycle detection).
    - #547: Number of Provinces (connected components).
    - #207: Course Schedule (cycle detection, adaptable with Disjoint Set).
- **Interview Preparation**: Explain the algorithm clearly, emphasizing optimizations and complexity.

## Conclusion
The Disjoint Set data structure is a powerful tool for solving problems involving grouping and connectivity. Its efficiency and simplicity make it a staple in graph algorithms, network design, and data processing. By mastering its implementation and applications, you can tackle a wide range of algorithmic challenges effectively.