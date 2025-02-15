### Resources

1. Course: https://gale.udemy.com/course/graph-theory-algorithms-for-competitive-programming
2. Java
   Solutions: https://github.com/coding-minutes/graph-algorithms-for-competitive-coding/tree/master/Graphs%20Java/src
3. https://github.com/MountAim/Graph-Coding-Minutes

### Cycle detection in Undirected Graph

Detecting a Cycle in an Undirected Graph
Approach: Union-Find (Disjoint Set) Algorithm
This method is based on the Union-Find (Disjoint Set) data structure using Path Compression and Union by Rank.

Steps:

1. Initialize a parent array where each node is its own parent.
2. Process each edge (u, v):
    1. Find the root parent of u and v.
    2. If both nodes have the same parent, a cycle exists.
    3. Otherwise, perform a union operation to merge their sets.
3. If all edges are processed without detecting the same root parent for both nodes in an edge, the graph is cycle-free.

Time Complexity:
O(E log V) (using path compression and union by rank)

OR Alternative Approach: DFS-Based Cycle Detection

1. Use DFS to traverse the graph.
2. Maintain a visited set to track visited nodes.
3. Maintain a parent map to track back edges.
4. If DFS encounters a visited node that is not the parent of the current node, a cycle exists.

### Cycle detection in Directed Graph

Approach: DFS with Recursion Stack

1. Maintain two sets:
    1. visited[]: Tracks all visited nodes.
    2. recStack[]: Tracks nodes in the current recursive path.
2. Start DFS traversal from each node:
    1. If a node is encountered that is already in recStack, a cycle exists.
    2. Otherwise, continue DFS.
    3. Remove the node from recStack after exploring all its children.
3. If no cycle is found, return false.

Time Complexity:
O(V + E)

OR Alternative Approach: Kahn’s Algorithm (Topological Sort)

1. Compute the in-degree of each node.
2. Enqueue nodes with in-degree = 0.
3. Process the queue:
    1. Reduce the in-degree of adjacent nodes.
    2. If any node’s in-degree becomes 0, enqueue it.
4. If all nodes are processed, there is no cycle.
5. If there are leftover nodes, a cycle exists.

# Breadth-First Search (BFS) vs. Depth-First Search (DFS)

## 📌 Comparison Table

| Feature            | BFS (Breadth-First Search) | DFS (Depth-First Search) |
|--------------------|---------------------------|---------------------------|
| **Data Structure** | Queue (FIFO)              | Stack (LIFO) (or recursion) |
| **Traversal Style** | Level-by-level            | Deep-path first |
| **Best
for**       | Shortest path, level order traversal, connected components | Backtracking, cycle detection, topological sorting |
| **Time Complexity** | `O(V + E)`               | `O(V + E)` |
| **Space Complexity** | `O(V)` (stores all nodes at a level) | `O(V)` (recursive stack or explicit stack storage) |
| **When to
Use**    | Finding shortest paths, shallow solutions | Deep searching, dependency resolution, memory-efficient sparse graphs |

---

## 🏆 Use Cases: When to Use BFS vs. DFS

| Problem                                      | Best Algorithm | Reason |
|----------------------------------------------|---------------|--------|
| **Shortest path in an unweighted graph**    | ✅ **BFS**   | Finds the shortest route first |
| **Finding if a path exists between two nodes** | 🔵 **DFS** | Faster for sparse graphs |
| **Maze solving (any path)**                  | 🔵 **DFS**   | Faster for deep paths |
| **Maze solving (shortest path)**             | ✅ **BFS**   | Finds the optimal solution |
| **Finding cycles in a graph**                | 🔵 **DFS**   | Detects back edges efficiently |
| **Web crawling**                             | ✅ **BFS** (if breadth-focused) / 🔵 **
DFS** (if depth-focused) | BFS finds closer pages first, DFS explores deeply |

---

- ✅ **Use BFS** for shortest paths, level-order traversal, and when the solution is closer to the root.
- 🔵 **Use DFS** for deep searches, backtracking problems, cycle detection, and when handling large, sparse graphs
  efficiently.

---

# Understanding Bipartite Graph 🧩

A **Bipartite Graph** is a graph whose vertices can be divided into **two disjoint sets** such that:

- Every edge connects a vertex from **one set to the other set**.
- **No edge connects vertices within the same set**.
- The graph is often represented as two sets:  
  **Set A** and **Set B**.
- Every edge in the graph connects one vertex from **Set A** to one vertex from **Set B**.

---

## How to Check if a Graph is Bipartite?

- Use **graph coloring**:
    - Assign colors (e.g., **Red** and **Blue**) to each node.
    - Adjacent nodes must have **different colors**.
- If any adjacent nodes have the **same color**, the graph is **not bipartite**.
- A graph is bipartite if:
    - It is 2-colorable.
    - Or, it contains no odd-length cycle.

---

## Common Applications:

- **Matching problems** (e.g., Job assignments, Network flow).
- **Scheduling problems**.
- **Map coloring**.

---

## Example:

A ---- B
<br>
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
<br>
C ---- D

- **Sets**: {A, C} and {B, D}
- Every edge connects nodes from different sets → **Bipartite!**

---

> **Quick Tip**:  
> *A graph with an **odd-length cycle** is never bipartite!* 🚀

# **Topological Sorting - Summary** 🚀

## **What is Topological Sorting?**

Topological sorting is a **linear ordering of vertices** in a **Directed Acyclic Graph (DAG)**, such that for every
directed edge **U → V**, vertex **U appears before V**.

---

## **Topological Sorting using BFS**

### **Solution Approach**

1. **Compute in-degree** (number of incoming edges) for each node.
2. **Add all nodes with in-degree 0** to a queue.
3. **Process nodes from the queue**:
    - Print or store the node.
    - Reduce the in-degree of its neighbors.
    - If a neighbor's in-degree becomes 0, **add it to the queue**.
4. **Repeat until the queue is empty**.

---

## **Topological Sorting using DFS**

### **Solution Approach**

1. **Represent the graph** using an adjacency list.
2. Use a **boolean array** to track visited nodes.
3. Perform **Depth-First Search (DFS)** for each unvisited node:
    - Mark the node as **visited**.
    - Recursively **visit all its adjacent nodes**.
    - Push the node onto a **stack** after processing all its neighbors.
4. After DFS completes for all nodes, **print the stack contents** as the topological order.

---

## **Applications of Topological Sorting**

✅ **Task Scheduling** (e.g., Course prerequisites in universities).  
✅ **Dependency Resolution** (e.g., Package installations, build systems).  
✅ **Deadlock Detection** in operating systems.  
✅ **Compiler Optimization** (ordering function calls).  
✅ **Job Scheduling** in workflow systems.

> **💡 Key Rule:** Topological sorting is **only possible in a Directed Acyclic Graph (DAG)**! 🚀