/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * You are given an integer array and a positive integer K. You have to tell if
 * there exists a pair of integers in the given array such that ar[i]-ar[j]=K
 * and i≠j
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-pair
 *       -with-difference-k
 *       <p>
 *       Solution: Complexity:O(nlogn)
 */
public final class PairWithDiffK {
	public static void main(String[] args) {
		int[] arr = { 1, 20, 40, 100, 80 };
		Arrays.sort(arr);
		boolean b = hasDiffPair(arr, 60);
		System.out.println(b);
	}

	private static boolean hasDiffPair(int[] arr, int k) {
		int p1 = 0, p2 = 0;
		while (p1 < arr.length && p2 < arr.length) {
			int diff = arr[p2] - arr[p1];
			if (diff == k && p1 != p2) {
				return true;
			} else if (diff < k) {
				p2++;
			} else {
				p1++;
			}
		}
		return false;
	}
}