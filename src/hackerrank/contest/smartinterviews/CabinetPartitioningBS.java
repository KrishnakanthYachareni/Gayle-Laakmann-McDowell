package hackerrank.contest.smartinterviews;

import java.util.Scanner;

/**
 * Solution: Using binary search
 * <p>
 * Complexity: O(n-1 C k-1), O(1)
 */
public final class CabinetPartitioningBS {

	public static void main(String[] args) {
		// int[] ar = {5, 10, 3, 1, 8, 4, 6, 2, 7, 3, 5, 4};
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			int k = sc.nextInt();
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			int ans = partition(ar, n, k);
			System.out.println(ans);
		}
	}

	public static int partition(int[] ar, int n, int k) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int value : ar) {
			max = Math.max(max, value);
			sum += value;
		}

		int low = max; // or max(ar, n); or average
		int high = sum, mid, ans = Integer.MIN_VALUE;

		if (n <= k) {
			return max;
		}
		while (low <= high) {
			mid = (low + high) / 2;
			if (isValidPartition(ar, n, k, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean isValidPartition(int[] ar, int n, int k, int mid) {
		int partitions = 1, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ar[i];
			if (sum > mid) {
				sum = ar[i];
				partitions++;
			}
		}
		return partitions <= k;
	}
}