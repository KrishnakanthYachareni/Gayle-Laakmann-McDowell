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
 *       Solution: check the smart interview notes for detaialed
 *       description. @Page 19.
 */
public final class TripleTroubleBitwise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			int result = solve(ar, n);
			System.out.println(result);
		}
	}

	private static int solve(int[] ar, int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int c = 0;
			for (int j = 0; j < n; j++) {
				if (checkBit(ar[j], i)) {
					c++;
				}
			}
			if (c % 3 == 1) {
				ans += 1 << i;
			}
		}
		return ans;
	}

	private static boolean checkBit(int n, int i) {
		return (n & (1 << i)) != 0;
	}
}