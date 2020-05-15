package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * Given an array, you have to find the floor of a number x. The floor of a
 * number x is nothing but the largest number in the array less than or equal to
 * x
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-the-floor
 *       <p>
 *       Solution: Implementation using binary search.
 *       <p>
 *       Complexity: O(NlogN + QlogN), O(N)
 */
public final class FloorOfANumberBinarySearch {
	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, 15, 5 };
		int[] queries = { -1, 10, 8, -10, -4 };
		Arrays.sort(ar);
		for (int q : queries) {
			int max = floor(ar, ar.length, q);
			System.out.println(max);
		}
	}

	private static int floor(int[] ar, int n, int x) {
		int low = 0, high = n - 1, mid;
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
			mid = (low + high) / 2;
			if (ar[mid] <= x) {
				ans = ar[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}
}
