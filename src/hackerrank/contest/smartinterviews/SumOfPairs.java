/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * Given an array of integers and a number K, check if there exist a pair of
 * indices i,j s.t. a[i] + a[j] = K and i!=j
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-
 *       of-pairs
 *       <p>
 *       Solution: First sort the array and then use two poniter technique to
 *       check the pairs of sum is equal to given k. Complexity: O(n)
 */
public final class SumOfPairs {
	public static void main(String[] args) {
		int[] arr = { -4, 0, 10, -7 };
		Arrays.sort(arr);
		boolean b = hasSumOfPair(arr, 7);
		System.out.println(b);
	}

	private static boolean hasSumOfPair(int[] arr, int k) {
		int p1 = 0, p2 = arr.length - 1;
		while (p1 < arr.length && p2 >= 0) {
			int sum = arr[p1] + arr[p2];
			if (sum == k && p1 != p2) {
				return true;
			} else if (sum > k) {
				p2--;
			} else {
				p1++;
			}
		}
		return false;
	}
}