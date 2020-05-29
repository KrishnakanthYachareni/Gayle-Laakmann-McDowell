package hackerrank.contest.smartinterviews.arrays;

/**
 * Given an array of integers, answer queries of the form: [i, j] : Print the
 * sum of array elements from A[i] to A[j], both inclusive.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-
 *       of-subarrays
 */
public final class SumOfSubArrays {
	public static void main(String[] args) {
		long[] ar = { 1, 30, 13, -4, -5, 12, -53, -12, 43, 100 };
		int i = 1, j = 7;
		long[] cSum = cumulativeSum(ar, ar.length);
		long ans = subArraySum(cSum, i, j);
		System.out.println(ans);
	}

	public static long subArraySum(long[] cSum, int i, int j) {
		if (i == 0) {
			return cSum[j];
		} else {
			return cSum[j] - cSum[i - 1];
		}
	}

	private static long[] cumulativeSum(long[] ar, int n) {
		for (int i = 1; i < n; i++) {
			ar[i] = ar[i] + ar[i - 1];
		}
		return ar;
	}
}
