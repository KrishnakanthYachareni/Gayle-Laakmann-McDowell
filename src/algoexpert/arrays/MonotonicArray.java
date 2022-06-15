package algoexpert.arrays;

/**
 * Write a function that takes in an array of integers and returns a boolean
 * representing whether the array is monotonic.
 * <p>
 * An array is said to be monotonic if its elements, from left to right, are
 * entirely non-increasing or entirely non-decreasing.
 * <p>
 * Non-increasing elements aren't necessarily exclusively decreasing; they simply
 * don't increase. Similarly, non-decreasing elements aren't necessarily
 * exclusively increasing; they simply don't decrease.
 * <p>
 * Note that empty arrays and arrays of one element are monotonic.
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        int n = array.length;
        if (n <= 2)
            return true;
        boolean isNonIncreasing = true, isNonDecreasing = true;
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1])
                isNonIncreasing = false;
            if (array[i] < array[i - 1])
                isNonDecreasing = false;
        }
        return isNonIncreasing || isNonDecreasing;
    }
}
