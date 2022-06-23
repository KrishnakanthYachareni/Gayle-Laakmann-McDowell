package algoexpert.searchingandsorting;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    /*
        TC = O(N log k) if k < N and O (N) if N == K
        SC = O (N + k)

        TODO: Write quick select solution
    */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // minHeap (lambda for descending order)
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        // O (N log k)
        for (int key : frequencyMap.keySet()) {
            heap.add(key);

            if (heap.size() > k)
                heap.poll();
        }

        // O (k log k)
        int[] topElements = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topElements[i] = heap.poll();
        }
        return topElements;
    }
}
