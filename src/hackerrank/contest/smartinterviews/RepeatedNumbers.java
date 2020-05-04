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
 *       Solution: Simply sort the array and iterate the array linearly & check
 *       for duplicates.
 */
public final class RepeatedNumbers {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			mergeSort(ar, 0, n - 1);
			findDuplicates(ar, n);
			System.out.println();
		}
	}

	private static void findDuplicates(int[] ar, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (ar[i] == ar[i + 1]) {
				System.out.print(ar[i] + " ");
			}
		}
	}

	private static void mergeSort(int[] ar, int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (high + low) / 2;
		mergeSort(ar, low, mid);
		mergeSort(ar, mid + 1, high);
		merge(ar, low, mid, high);
	}

	private static void merge(int[] ar, int low, int mid, int high) {
		int p1 = low, p2 = mid + 1, index = 0;
		int[] temp = new int[high - low + 1];
		while (p1 <= mid && p2 <= high) {
			if (ar[p1] < ar[p2]) {
				temp[index++] = ar[p1++];
			} else {
				temp[index++] = ar[p2++];
			}
		}
		while (p1 <= mid) {
			temp[index++] = ar[p1++];
		}
		while (p2 <= high) {
			temp[index++] = ar[p2++];
		}
		for (int i = low; i <= high; i++) {
			ar[i] = temp[i - low];
		}
	}
}