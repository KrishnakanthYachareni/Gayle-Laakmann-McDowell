package algoexpert.arrays;

import java.util.Arrays;

/**
 * Write a function that takes in two non-empty arrays of integers, finds the
 * pair of numbers (one from each array) whose absolute difference is closest to
 * zero, and returns an array containing these two numbers, with the number from
 * the first array in the first position.
 * <p>
 * Note that the absolute difference of two integers is the distance between
 * them on the real number line. For example, the absolute difference of -5 and 5
 * is 10, and the absolute difference of -5 and -4 is 1.
 * <p>
 * You can assume that there will only be one pair of numbers with the smallest
 * difference.
 */
public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, j = 0, n = arrayOne.length, m = arrayTwo.length;
        int minDiff = Integer.MAX_VALUE, currDiff;
        int[] ans = new int[2];
        while (i < n && j < m) {
            int firstNumber = arrayOne[i], secondNumber = arrayTwo[j];
            if (firstNumber > secondNumber) {
                currDiff = firstNumber - secondNumber;
                j++;
            } else if (secondNumber > firstNumber) {
                currDiff = secondNumber - firstNumber;
                i++;
            } else {
                return new int[]{firstNumber, secondNumber};
            }
            if (currDiff < minDiff) {
                minDiff = currDiff;
                ans = new int[]{firstNumber, secondNumber};
            }
        }
        return ans;
    }
}
