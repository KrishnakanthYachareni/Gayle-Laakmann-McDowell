package algoexpert.arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class SubarraySort {
    // TC = O(N), SC = O(1)
    public static int[] subarraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE, maxOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
            if (isOutOfOrder(array, i)) {
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        // if array is already sorted.
        if (minOutOfOrder == Integer.MAX_VALUE)
            return new int[]{-1, -1};

        // Find the left, right indexes of the sub array.
        int leftSubIndex = 0;
        while (array[leftSubIndex] <= minOutOfOrder)
            leftSubIndex++;

        int rightSubIndex = array.length - 1;
        while (array[rightSubIndex] >= maxOutOfOrder)
            rightSubIndex--;

        return new int[]{leftSubIndex, rightSubIndex};
    }

    private static boolean isOutOfOrder(int[] array, int i) {
        if (i == 0)
            return array[i] > array[i + 1];
        else if (i == array.length - 1)
            return array[i] < array[i - 1];
        else
            return array[i] < array[i - 1] || array[i] > array[i + 1];
    }
}
