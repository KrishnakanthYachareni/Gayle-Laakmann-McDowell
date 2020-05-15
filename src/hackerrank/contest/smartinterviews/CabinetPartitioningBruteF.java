package hackerrank.contest.smartinterviews;

/**
 * Solution: it is brute force approach
 * <p>
 * Complexity: O(n-1 C k-1), O(1)
 */
public final class CabinetPartitioningBruteF {

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] ar = { 5, 10, 3, 1, 8, 4, 6, 2, 7, 3, 5, 4 };
		// int[] ar = {30, 60};
		int k = 4;
		if (k >= ar.length) {
			System.out.println(max(ar));
		} else {
			solve(ar, ar.length, k, 0, 0);
			System.out.println(ans);
		}
	}

	static void solve(int[] ar, int n, int k, int idx, int mcp) {
		if (k == 1) {
			int s = sum(ar, idx, n - 1);
			mcp = Math.max(mcp, s);
			ans = Math.min(ans, mcp);
			return;
		}
		int s = 0;
		for (int i = idx; i < n; i++) {
			s += ar[i];
			solve(ar, n, k - 1, i + 1, Math.max(mcp, s));
		}
	}

	private static int sum(int[] ar, int idx, int n) {
		int sum = 0;
		for (int i = idx; i <= n; i++) {
			sum += ar[i];
		}
		return sum;
	}

	private static int max(int[] ar) {
		int max = Integer.MIN_VALUE;
		for (int value : ar) {
			max = Math.max(max, value);
		}
		return max;
	}
}