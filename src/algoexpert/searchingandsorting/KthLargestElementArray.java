package algoexpert.searchingandsorting;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementArray {


    /*
        Approach: Quick Select
        TC = O(N), SC = O(1)

        Video: https://www.algoexpert.io/questions/quickselect
        QuickSort: https://www.youtube.com/watch?v=SLauY6PpjW4
    */
    public int findKthLargest(int[] nums, int k) {
        int position = nums.length - k; // Since need Kth Largest element.

        return quickSelect(nums, 0, nums.length - 1, position);
    }

    private int quickSelect(int[] nums, int startIdx, int endIdx, int k) {
        while (true) {
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1; // Skipping pivot in the loop
            int rightIdx = endIdx;

            while (leftIdx <= rightIdx) {
                if (nums[leftIdx] > nums[pivotIdx] && nums[rightIdx] < nums[pivotIdx])
                    swap(nums, leftIdx, rightIdx);

                if (nums[leftIdx] <= nums[pivotIdx])
                    leftIdx++;

                if (nums[rightIdx] >= nums[pivotIdx])
                    rightIdx--;
            }

            swap(nums, pivotIdx, rightIdx); // Now pivot is in it's correct place.

            if (rightIdx == k) {
                return nums[rightIdx];
            } else if (k < rightIdx) {
                endIdx = rightIdx - 1; // Note: updating in parent variables
            } else {
                startIdx = rightIdx + 1;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    //  TC = O(N log K), SC = O(k)
    /*public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first' (min Heap)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);

            // keep k the largest elements in the heap and remove small elements if exceeds k
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }*/
}
