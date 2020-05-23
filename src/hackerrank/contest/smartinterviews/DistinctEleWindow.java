package hackerrank.contest.smartinterviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers and a window size K, find the number of distinct
 * elements in every window of size K of the given array.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       distinct-elements-in-window/problem
 */
public final class DistinctEleWindow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int k = sc.nextInt();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			distinctElements(arr, n, k);
			System.out.println();
		}
	}

	protected static void distinctElements(int[] ar, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int kthEnd = 0;
		for (int i = 0; i < k; i++) {
			kthEnd = i;
			map.compute(ar[i], (key, value) -> {
				if (map.containsKey(key)) {
					return value + 1;
				} else {
					return 1;
				}
			});
		}
		int p1 = 0;
		kthEnd += 1;
		while (p1 < n && kthEnd <= n) {
			System.out.print(map.size() + " ");
			int va = map.get(ar[p1]);
			// Remove from window
			if (va > 1) {
				map.put(ar[p1], va - 1);
			} else {
				map.remove(ar[p1]);
			}
			p1++;
			// Adding to window
			if (kthEnd < n) {
				if (map.containsKey(ar[kthEnd])) {
					map.put(ar[kthEnd], map.get(ar[kthEnd]) + 1);
				} else {
					map.put(ar[kthEnd], 1);
				}
			}
			kthEnd++;
		}
	}
}