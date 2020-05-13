/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * Given an array, find the length of the longest subsequence whose elements can
 * be re-arranged in a strictly increasing contiguous order. The difference
 * between 2 adjacent elements in the subsequence, after re-arrangement, should
 * be exactly 1
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       maximum-contiguous-subsequence
 *       <p>
 *       Solution: Complexity:
 */
public final class MaxContiguousSubSequence {
	public static void main(String[] args) {
		int[] arr = { 1, 1 };
		int ans = maxSubArrayLen(arr);
		System.out.println(ans);
	}

	private static int maxSubArrayLen(int[] arr) {
		Arrays.sort(arr);
		int maxLen = 1;
		int currentLen = maxLen;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == 1) {
				currentLen++;
			} else if (arr[i + 1] != arr[i]) {
				currentLen = 1;
			}
			maxLen = Math.max(maxLen, currentLen);
		}
		return maxLen;
	}
}