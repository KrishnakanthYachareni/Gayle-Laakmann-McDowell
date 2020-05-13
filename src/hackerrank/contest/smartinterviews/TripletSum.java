package hackerrank.contest.smartinterviews;

import java.util.Arrays;

/**
 * You are given an integer array and a number K. You have to tell if there
 * exists i,j,k in the given array such that ar[i]+ar[j]+ar[k]=K, i≠j≠k
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       triplet-with-sum-k
 */
public final class TripletSum {
	public static void main(String[] args) {
		int[] arr = { 12, 45, 52, 65, 21, 645, 234, -100, 14, 575, -80, 112 };
		Arrays.sort(arr);
		boolean ans = isTriplet(arr, arr.length, 54);
		System.out.println(ans);
	}

	private static boolean isTriplet(int[] ar, int n, int k) {
		for (int i = 0; i < n; i++) {
			int a = ar[i];
			int p1 = i + 1, p2 = n - 1;
			while (p1 < n && p2 >= 0) {
				if (ar[p1] + ar[p2] == k - a && i != p1 && i != p2 && p1 != p2) {
					return true;
				} else if (ar[p1] + ar[p2] < k - a) {
					p1++;
				} else {
					p2--;
				}
			}
		}
		return false;
	}
}
