package hackerrank.contest.smartinterviews.arrays;

import java.util.Scanner;

/**
 * You are given the heights of N buildings. All the buildings are of width 1
 * and are adjacent to each other with no empty space in between. Assume that
 * its raining heavily, and as such water will be accumulated on top of certain
 * buildings. Your task is to find the total amount of water accumulated
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       collecting-water
 *       <p>
 *       Complexity: O(n), O(1)
 */
public final class CollectingWater {
	public static void main(String[] args) {
		// int[] ar = {1, 6, 2, 4, 5, 7, 9}; //Output: 7
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		while (t-- > 0) {
			n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			int ans = amountOfWater(ar, n);
			System.out.println(ans);
		}
	}

	public static int amountOfWater(int[] ar, int n) {
		int p1 = 0, p2 = n - 1, leftMax = 0, rightMax = 0, ans = 0;
		while (p1 < p2) {
			if (ar[p1] < ar[p2]) {
				if (ar[p1] > leftMax) {
					leftMax = ar[p1];
				} else {
					ans += (leftMax - ar[p1]);
				}
				p1++;
			} else {
				if (ar[p2] > rightMax) {
					rightMax = ar[p2];
				} else {
					ans += (rightMax - ar[p2]);
				}
				p2--;
			}
		}
		return ans;
	}
}
