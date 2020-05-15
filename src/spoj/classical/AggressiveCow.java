package spoj.classical;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @link https://www.spoj.com/problems/AGGRCOW/
 */
public final class AggressiveCow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			int n = sc.nextInt();
			int persons = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			Arrays.sort(ar);
			int ans = findMaxDistance(ar[n - 1], persons, ar);
			System.out.println(ans);
		}
	}

	private static int findMaxDistance(int max, int persons, int[] ar) {
		int low = 0, high = max, mid, ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (isValid(ar, mid, persons)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private static boolean isValid(int[] ar, int mid, int cows) {
		int pre = ar[0], count = 1;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] - pre >= mid) { // At least minimum distance(mid) apart to
										// place the cows
				pre = ar[i];
				count++;
				if (count == cows) {
					return true;
				}
			}
		}
		return false;
	}
}
