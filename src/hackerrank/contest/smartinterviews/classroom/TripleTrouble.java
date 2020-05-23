package hackerrank.contest.smartinterviews.classroom;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size 3X+1, where every element occurs three times, except
 * one element, which occurs only once. Find the element that occurs only once.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       triple-trouble
 *       <p>
 *       Solution: First sort the array using merge sort and iterate through the
 *       array linearly with the window size of 3 and check window elements are
 *       not same.
 */
public final class TripleTrouble {
	public static void main(String[] args) {
		int[] ar = { 5, 7, 8, 7, 7, 5, 5, 9, 8, 8 };
		int ans = uniqueNumber(ar);
		System.out.println(ans);
	}

	public static int uniqueNumber(int[] ar) {
		Map<Integer, Integer> countMap = countMap(ar);
		for (Map.Entry<Integer, Integer> x : countMap.entrySet()) {
			if (x.getValue() == 1) {
				return x.getKey();
			}
		}
		return -1;
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