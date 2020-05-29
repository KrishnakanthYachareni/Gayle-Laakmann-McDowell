package hackerrank.contest.smartinterviews.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given a array containing only 0s and 1s . You have to tell the number
 * of subarrays which has equal number of 0s and 1s.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       number-of-valid-subarrays
 *       <p>
 *       Reference: https://leetcode.com/articles/contiguous-array/
 */
public final class ValidSubArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			int ans = countSubArrays(ar);
			System.out.println(ans);
		}
	}

	public static int countSubArrays(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int cSum = 0, ans = 0;
		for (int value : arr) {
			cSum += value == 0 ? -1 : 1; // replace 0 with -1
			if (cSum == 0) { // if commutative sum is 0, Then it is one sub
								// array.
				ans++;
			}
			if (map.containsKey(cSum)) {
				ans += map.get(cSum);
			}
			map.put(cSum, map.getOrDefault(cSum, 0) + 1);
		}
		return ans;
	}

	/**
	 * Brute Force implementation:
	 * <p>
	 * We consider every possible subarray within the given array and count the
	 * number of zeros and ones in each subarray. Then, count the no of number
	 * of sub arrays.
	 * <p>
	 * Complexity : O(n^2), O(1)
	 */
	public static int countSubArraysBt(int[] ar) {
		int ans = 0;
		for (int i = 0; i < ar.length; i++) {
			int zeroes = 0, ones = 0;
			for (int j = i; j < ar.length; j++) {
				if (ar[j] == 0) {
					zeroes++;
				} else {
					ones++;
				}
				if (zeroes == ones) {
					ans++;
				}
			}
		}
		return ans;
	}
}