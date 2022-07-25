package algoexpert.famous;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum

    Link: https://leetcode.com/problems/maximum-subarray/
 */
public class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int maximumSum = array[0];

        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}

