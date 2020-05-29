package hackerrank.contest.smartinterviews.arrays;

import java.util.Arrays;

/**
 * You are given 4 arrays - A, B, C, D of integers. You have to find the number
 * of quadruples (i, j, k, l) such that A[i]^B[j]^C[k]^D[l] = 0, where ^ is the
 * bitwise XOR operator
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       quadruples-of-xor
 */
public final class QuadruplesOfXOR {
	public static void main(String[] args) {
		int[] a = { 31, 8, 28, 10 };
		int[] b = { 18, 7, 22, 5 };
		int[] c = { 16, 25, 20, 14 };
		int[] d = { 39, 9, 34, 19 };
		int ans = countQuadruples(a, b, c, d, a.length);
		System.out.println(ans);
	}

	public static int countQuadruples(int[] a, int[] b, int[] c, int[] d, int n) {
		int ans = 0;
		int[] aXorB = new int[n * n];
		int[] cXorD = new int[n * n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				aXorB[index] = a[i] ^ b[j];
				cXorD[index] = c[i] ^ d[j];
				index++;
			}
		}
		Arrays.sort(aXorB);
		for (int i = 0; i < n * n; i++) {
			int left = bsLeftIndex(aXorB, aXorB.length, cXorD[i]);
			int right = bsRightIndex(aXorB, aXorB.length, cXorD[i]);
			ans += (right - left) + 1;
		}
		return ans;
	}

	private static int bsLeftIndex(int[] ar, int length, int x) {
		int p1 = 1, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar[mid]) {
				high = mid - 1;
			} else if (x > ar[mid]) {
				low = mid + 1;
			} else {
				p1 = mid;
				high = mid - 1;
			}
		}
		return p1;
	}

	private static int bsRightIndex(int[] ar, int length, int x) {
		int p2 = 0, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar[mid]) {
				high = mid - 1;
			} else if (x > ar[mid]) {
				low = mid + 1;
			} else {
				p2 = mid;
				low = mid + 1;
			}
		}
		return p2;
	}
}