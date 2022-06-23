package algoexpert.searchingandsorting;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosetPointsToOrigin {

    /*
     * TC = O(N log k), SC = O(k)
     *
     * TODO: Do binary search approach
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) { // Remove the longest distance points after exceeding the size of k
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (maxHeap.size() > 0) {
            result[i] = maxHeap.poll();
            i++;
        }
        return result;
    }

    private int distance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
