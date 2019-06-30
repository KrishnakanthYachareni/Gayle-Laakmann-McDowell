/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class EvenBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        for (int t = 0; t < noOfTests; t++) {
            int arrSize = sc.nextInt();
            int[] input = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                input[i] = sc.nextInt();
            }
            for (int i = 0; i < input.length; i++) {
                if (-1 == input[i]) {
                    int prev = input[i - 1];
                    int computedNum = 0 == prev % 2 ? prev : prev + 1;
                    input[i] = findMinOddBitNum(computedNum);
                }
            }
            System.out.println(Arrays.stream(input).sum());
        }
    }

    private static int findMinOddBitNum(int n) {
        while (true) {
            if (isEligibleNumber(n)) {
                return n;
            }
            n = n + 2;
        }
    }

    private static boolean isEligibleNumber(int n) {
        if (1 == n % 2) {
            return false;
        }
        StringBuffer bits = new StringBuffer(Integer.toBinaryString(n)).reverse();
        for (int i = 0; i < bits.length(); i += 2) {
            if ('1' == bits.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
