package hackerrank.contest.smartinterviews;

import java.util.Scanner;

/**
 * You are given an array of integers. Sort them by frequency. See examples for
 * more clarifications.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       frequency-sort/problem
 *       <p>
 *       Input: 176 -272 -272 -45 269 -327 -945 176
 *       <p>
 *       output: -945 -327 -45 269 -272 -272 176 176
 */
public final class FrequencySort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int low = -1000, high = 1000;
		int range = (high - low) + 1;
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			int count[] = new int[range];
			int size = findFrequency(ar, ar.length, low, count);
			insertionSort(ar, count, size);
			System.out.println();
		}
	}

	public static int findFrequency(int[] ar, int n, int low, int[] count) {
		for (int i = 0; i < n; i++) {
			count[ar[i] - low]++;
		}
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				ar[index] = low + i;
				count[index] = count[i];
				index++;
			}
		}
		return index;
	}

	private static void insertionSort(int[] ar, int[] count, int n) {
		for (int i = 0; i < n; i++) {
			int temp = count[i];
			int arTemp = ar[i];
			int j = i;
			while (j > 0 && temp < count[j - 1]) {
				count[j] = count[j - 1];
				ar[j] = ar[j - 1];
				j--;
			}
			count[j] = temp;
			ar[j] = arTemp;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < count[i]; j++) {
				if (i < n - 1 && count[i] == count[i + 1]) {
					System.out.print((ar[i] < ar[i + 1] ? ar[i] : ar[i + 1]) + " ");
				} else {
					System.out.print(ar[i] + " ");
				}
			}
		}
	}
}
