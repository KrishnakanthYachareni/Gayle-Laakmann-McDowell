/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package algorithms.sortings;

import java.util.Arrays;

/**
 * Merge Sort implementation using recursion.
 */
public final class MergeSort {
	public static void main(String[] args) {
		int[] ar = { 1, 4, 3, 2, 5 };
		mergeSort(ar, 0, ar.length - 1);
		System.out.println(Arrays.toString(ar));
	}

	public static void mergeSort(int[] ar, int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (high + low) / 2;
		mergeSort(ar, low, mid);
		mergeSort(ar, mid + 1, high);
		merge(ar, low, mid, high);
	}

	/**
	 * Given the two sorted arrays merge then into one array and sort it. The
	 * below method is being used Two pointer mechanism to sort the array.
	 */
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
