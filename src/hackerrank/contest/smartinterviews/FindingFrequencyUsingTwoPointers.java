package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * Given an array,you have to find the frequency of a number
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-frequency
 *       <p>
 *       Solution: Implementation using two pointer techniques, binary search.
 *       <p>
 *       Complexity: O(QlogQ + NlogN + Q+N + QlogQ), O(N + Q)
 */
public final class FindingFrequencyUsingTwoPointers {

	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		int[] orgQuery = { -1, 10, 8, 15, 20 };// To keep the output order
		int[] query = orgQuery.clone();

		int[] ans = new int[ar.length];
		Arrays.sort(ar);
		Arrays.sort(query);

		int size = frequency(ar, ar.length, query, query.length, ans);
		print(ar, orgQuery, ans, size); // Print according query output order
	}

	private static int frequency(int[] ar, int n, int[] query, int q, int[] ans) {
		int p1 = 0, p2 = 0;
		int count = 0, index = 0;
		while (p1 < n && p2 < q) {
			while (p1 < n && ar[p1] <= query[p2]) {
				if (ar[p1] == query[p2]) {
					count++;
				} else {
					ans[index] = 1;
					ar[index] = ar[p1];
					index++;
				}
				p1++;
			}
			ans[index] = count;
			count = 0;
			if (p1 != 0) {
				ar[index] = ar[p1 - 1];
			}
			index++;
			p2++;
		}
		while (p1 < n) {
			ans[index] = 1;
			ar[index] = ar[p1];
			p1++;
			index++;
		}
		return index;
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

	private static void print(int[] ar, int[] query, int[] ans, int size) {
		for (int value : query) {
			int index = bs(ar, 0, size, value);
			System.out.println(index == -1 ? 0 : ans[index]);
		}
	}
}