/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package hackerrank.contest.smartinterviews;

import java.util.Scanner;

/**
 * Given an array of size 3X+1, where every element occurs three times, except
 * one element, which occurs only once. Find the element that occurs only once.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       triple-trouble
 *       <p>
 *       Solution: First sort the array using merge sort and iterate through the
 *       array linearly with the window size of 3 and check window elements are
 *       not same.
 */
public final class TripleTrouble {
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
			int ans = uniqueNumber(ar, n);
			System.out.println(ans);
		}
	}

	/**
	 * Iterate the array linearly and check if window of 3 range numbers are not
	 * equal, then return the particular unique value.
	 */
	public static int uniqueNumber(int[] ar, int n) {
		for (int i = 0; i < n; i += 3) {
			if (i + 1 == n || ar[i + 1] != ar[i]) {
				return ar[i];
			}
		}
		return -1;
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