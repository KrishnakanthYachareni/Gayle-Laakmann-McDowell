/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package hackerrank.contest.smartinterviews;

import java.util.Scanner;

/**
 * You are given an array of n+2 elements. All elements of the array are in
 * range 1 to n. All elements occur once except two numbers, which occur twice.
 * Your task is to find the two repeating numbers
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       repeated-numbers/problem
 *       <p>
 *       Solution: Implementation using XOR.
 */
public final class RepeatedNumbersXor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			repeatedNumbers(ar, n - 2);
		}
	}

	private static void repeatedNumbers(int[] ar, int n) {
		int x = 0, kthBit;
		for (int item : ar) {
			x ^= item;
		}
		for (int i = 1; i <= n; i++) {
			x ^= i;
		}
		kthBit = x & ~(x - 1); // or x & -x
		int a = 0, b = 0;
		for (int value : ar) {
			int rightMostBit = value & kthBit;
			if (rightMostBit != 0) {
				a ^= value;
			} else {
				b ^= value;
			}
		}
		for (int i = 1; i <= n; i++) {
			int rightMostBit = i & kthBit;
			if (rightMostBit != 0) {
				a ^= i;
			} else {
				b ^= i;
			}
		}
		if (a <= b) {
			System.out.println(a + " " + b);
		} else {
			System.out.println(b + " " + a);
		}
	}
}