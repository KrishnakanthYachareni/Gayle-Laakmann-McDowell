package algoexpert.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    private static final int WHITE = 0; // Unvisited
    private static final int GREY = 1; // Processing
    private static final int BLACK = 2; // Finished

    // TC = O (|E| + |V|) where |V| is the number of courses, and |E| is the number of dependencies.
    // SC = O (|E| + |V|)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = prepareAdjacencyList(numCourses, prerequisites);
        int[] colors = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (colors[i] != WHITE)
                continue;

            boolean isCycle = isGraphCyclic(i, adj, colors);
            if (isCycle)
                return false;
        }
        return true;
    }

    private boolean isGraphCyclic(int node, List<List<Integer>> adj, int[] colors) {
        if (colors[node] == GREY) // Back edge forms a cycle
            return true;
        colors[node] = GREY; // Mark node is processing

        List<Integer> neighbors = adj.get(node);
        for (Integer neighbor : neighbors) {
            if (colors[neighbor] == BLACK) // Skip if the node is already visited
                continue;

            boolean isCycle = isGraphCyclic(neighbor, adj, colors);
            if (isCycle) {
                return true;
            }
        }
        colors[node] = BLACK; // Mark node is finished
        return false;
    }

    private List<List<Integer>> prepareAdjacencyList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites)
            adj.get(prerequisite[1]).add(prerequisite[0]); // prerequisite[0] depends on prerequisite[1]

        return adj;
    }
}
