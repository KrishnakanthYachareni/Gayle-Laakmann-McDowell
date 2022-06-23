package algoexpert.searchingandsorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    /*
        Approach:
        1. Sort the meetings based on start time and maintain the minHeap to keep
        ending times of meeting.
        2. If ending time of meeting in minHeap is less than starting time of current           meeting then remove the endtime from minHeap else add it to the heap
        3. After complete iteration of an array size of the heap is required number of           meetings.

        TC = O(N log N), SC = O(N)
    */
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        // Sort the intervals based on start time of meetings
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Maintain the end times list
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // minHeap by default
        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(interval[1]);
        }
        return heap.size();
    }
}
