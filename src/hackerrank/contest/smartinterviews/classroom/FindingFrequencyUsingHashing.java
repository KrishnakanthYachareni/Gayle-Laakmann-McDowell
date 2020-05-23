package hackerrank.contest.smartinterviews.classroom;

import java.util.HashMap;
import java.util.Map;

/***
 * Given an array,you have to find the frequency of a number
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-frequency
 *
 *       Sol: Insert the elements into map and maintains the occurence counts
 *       while putting into it.
 */
public final class FindingFrequencyUsingHashing {
	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		int[] queries = { -1, 10, 8, 15, 20 };

		Map<Integer, Integer> countMap = frequency(ar);
		for (int x : queries) {
			System.out.println(countMap.get(x) == null ? 0 : countMap.get(x));
		}
	}

	private static Map<Integer, Integer> frequency(int[] ar) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int item : ar) {
			countMap.compute(item, (key, val) -> {
				if (countMap.containsKey(item)) {
					return val + 1;
				} else {
					return 1;
				}
			});
		}
		return countMap;
	}
}