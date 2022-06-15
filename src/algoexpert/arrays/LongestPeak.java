package algoexpert.arrays;

/**
 * Write a function that takes in an array of integers and returns the length of
 * the longest peak in the array.
 * <p>
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class LongestPeak {
    public static int longestPeak(int[] array) {
        int longestPeakLen = 0, n = array.length;
        int i = 1;

        while (i < n - 1) {
            boolean isPeak = array[i - 1] < array[i] && array[i + 1] < array[i];
            if (!isPeak) {
                i++;
                continue;
            }
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1])
                leftIdx--;

            int rightIdx = i + 2;
            while (rightIdx < n && array[rightIdx - 1] > array[rightIdx])
                rightIdx++;

            longestPeakLen = Math.max(longestPeakLen, rightIdx - leftIdx - 1);
            i = rightIdx;
        }
        return longestPeakLen;
    }
}
