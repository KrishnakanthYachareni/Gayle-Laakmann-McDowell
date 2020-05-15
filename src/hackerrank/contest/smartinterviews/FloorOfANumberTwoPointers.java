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
 *       Solution: Implementation using two pointer techniques, binary search.
 *       <p>
 *       Complexity: O(QlogQ + NlogN + Q+N + QlogQ), O(N + Q)
 */
public final class FloorOfANumberTwoPointers {

	public static void main(String[] args) {
		int[] ar = { -7, -3, 3, 10, 15, 18, 25 };
		int[] orgQuery = { -4, -15, 9, 9, 17, 40, 30, 40, 53, 18 }; // To keep
																	// the
																	// output
																	// order
		int[] query = orgQuery.clone();
		int[] ans = new int[query.length];
		Arrays.sort(ar);
		Arrays.sort(query);
		floor(ar, ar.length, query, query.length, ans);
		print(orgQuery, query, ans); // Print according query output order
	}

	private static void floor(int[] ar, int n, int[] query, int q, int[] ans) {
		int p1 = 0, p2 = 0;
		int max = Integer.MIN_VALUE, index = 0;
		while (p1 < n && p2 < q) {
			while (p1 < n && ar[p1] <= query[p2]) {
				max = ar[p1];
				p1++;
			}
			ans[index++] = max;
			p2++;
			if (p2 > 0 && p2 < q && query[p2] == query[p2 - 1]) {
				p1--;
			}
			max = Integer.MIN_VALUE;
		}
		int lastMax = ans[index - 1];
		while (p2 < q) {
			ans[index++] = lastMax;
			p2++;
		}
	}

	private static int bs(int[] arr, int low, int high, int k) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (k < arr[mid]) {
				return bs(arr, low, mid - 1, k);
			} else {
				return bs(arr, mid + 1, high, k);
			}
		}
	}

	private static void print(int[] orgOuery, int[] query, int[] ans) {
		for (int item : orgOuery) {
			int index = bs(query, 0, query.length, item);
			System.out.println((ans[index]));
		}
	}
}