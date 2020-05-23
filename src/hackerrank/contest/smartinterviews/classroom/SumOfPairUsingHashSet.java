package hackerrank.contest.smartinterviews.classroom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and a number K, check if there exist a pair of
 * indices i,j s.t. a[i] + a[j] = K and i!=j.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-
 *       of-pairs/problem
 */
public final class SumOfPairUsingHashSet {
	public static void main(String[] args) {
		int[] arr = { -4, 0, 10, 10, -7 };
		Arrays.sort(arr);
		boolean b = hasSumOfPair(arr, arr.length, 10);
		System.out.println(b);
	}

	public static boolean hasSumOfPair(int[] ar, int n, int k) {
		Set<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int a = ar[i];
			int b = k - a;
			if (hashSet.contains(b)) {
				return true;
			} else {
				hashSet.add(a);
			}
		}
		return false;
	}
}