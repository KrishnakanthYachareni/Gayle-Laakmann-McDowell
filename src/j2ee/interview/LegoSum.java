package j2ee.interview;

import java.util.Arrays;

import java.util.Arrays;

import java.util.Arrays;

import java.util.Arrays;

import java.util.Arrays;

public class LegoSum {

    public static int findMinimumEqualSum(int[] rowA, int[] rowB) {
        int sumA = Arrays.stream(rowA).sum();
        int sumB = Arrays.stream(rowB).sum();

        if ((sumA - sumB) % 2 != 0) {
            return -1;
        }

        int targetDiff = (sumA - sumB) / 2;

        Arrays.sort(rowB);

        for (int numA : rowA) {
            int numToReplace = numA - targetDiff;

            if (numA == 0 || Arrays.binarySearch(rowB, numToReplace) >= 0) {
                return sumA - targetDiff;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] rowA = {1, 0, 2};
        int[] rowB = {1, 3, 0, 0};

        int result = findMinimumEqualSum(rowA, rowB);

        System.out.println("Minimum Equal Sum: " + result);
    }
}








