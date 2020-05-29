package hackerrank.contest.smartinterviews.string;

/**
 * Given an 2 strings A and B, find the number of occurrences of A in B as a
 * substring. Solve using Rabin-Karp string matching algorithm with multiple
 * hash functions. Do not use inbuilt library.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       rabin-karp-string-matching-algorithm
 *       <p>
 *       Explanation1: https://brilliant.org/wiki/rabin-karp-algorithm/
 *       <p>
 *       Explanation2:
 *       https://www.topcoder.com/community/competitive-programming/tutorials/
 *       introduction-to-string-searching-algorithms/
 */
public final class RobinKarpStringMatching {
	private static final long P = 101; // Can be any prime to avoid the
										// collisions.
	private static final long K = (long) (1e9 + 7);

	public static void main(String[] args) {
		String a = "yekicmsmartplrplsmartrplplmrpsmartrpsmartwmrmsmartsmart";
		String b = "smart";
		int ans = countMatches(a, a.length(), b, b.length());
		System.out.println(ans);
	}

	public static int countMatches(String a, int n, String b, int m) {
		int ans = 0;
		long[] PR = new long[m + 1];
		PR[0] = 1;
		for (int i = 1; i <= m; i++) {
			PR[i] = (PR[i - 1] * P) % K;
		}
		long hashB = 0, hashA = 0;
		for (int i = 0; i < m; i++) {
			hashB = (hashB + (b.charAt(i) * PR[m - i])) % K;
			hashA = (hashA + (a.charAt(i) * PR[m - i])) % K;
		}
		if (hashA == hashB) {
			ans++;
		}
		for (int i = m; i < n; i++) {
			hashA = (((hashA - a.charAt(i - m) * PR[m] + a.charAt(i)) * P) % K + K) % K;
			if (hashA == hashB) {
				ans++;
			}
		}
		return ans;
	}
}