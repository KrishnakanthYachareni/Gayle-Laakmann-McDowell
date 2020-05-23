package hackerrank.contest.smartinterviews.classroom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and a number K, check if there exist a pair of
 * indices i,j s.t. a[i] + a[j] = K and i!=j.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-
 *       of-pairs/problem
 */
public final class SumOfPairUsingHashMap {
	public static void main(String[] args) {
		int[] arr = { -4, 0, 10, 10, -7 };
		Arrays.sort(arr);
		boolean b = hasSumOfPair(arr, arr.length, 10);
		System.out.println(b);
	}

	public static boolean hasSumOfPair(int[] ar, int n, int k) {
		Map<Integer, Integer> map = countMap(ar);
		int b;
		for (int a : ar) {
			b = k - a;
			if (map.containsKey(b) && (a == b && map.get(b) > 1 || a != b && map.get(b) > 0)) {
				return true;
			}
		}
		return false;
	}

	private static Map<Integer, Integer> countMap(int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : ar) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}
		return map;
	}
}