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
 *       Solution: Complexity:
 */
public final class PairWithDiffK {
	public static void main(String[] args) {
		int[] arr = { 12, 45, 52, 65, 21, 645, 234, 14, 575, 112 };
		Arrays.sort(arr);
		boolean b = hasDiffPair(arr, 11);
		System.out.println(b);
	}

	// TODO: Incomplete solution
	private static boolean hasDiffPair(int[] arr, int k) {
		int p1 = 0, p2 = arr.length - 1;
		while (p1 < arr.length && p2 >= 0) {
			int diff = Math.abs(arr[p2] - arr[p1]);
			if (diff == k) {
				return true;
			} else if (diff > k) {
				p1++;
			} else {
				p2--;
			}
		}
		return false;
	}

}