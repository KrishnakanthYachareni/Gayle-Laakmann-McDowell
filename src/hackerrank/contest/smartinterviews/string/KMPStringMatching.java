package hackerrank.contest.smartinterviews.string;

/**
 * Given an 2 strings A and B, find the number of occurrences of A in B as a
 * substring. Solve using KMP string matching algorithm. Do not use inbuilt
 * library.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-kmp-
 *       string-matching-algorithm
 *       <p>
 *       Explanation: https://www.youtube.com/watch?v=GTJr8OvyEVQ
 */
public final class KMPStringMatching {
	public static void main(String[] args) {
		String a = "aaaaaaaa";
		String b = "aa";
		int ans = countMatches(a, b);
		System.out.println(ans);
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public static int countMatches(String a, String b) {
		int[] lps = largestPrefixSuffix(b); // Largest Prefix & Suffix.
		int i = 0, j = 0, ans = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
			if (j == b.length()) {
				ans++;
				j = lps[j - 1];
				// When we find pattern first time, we iterate again to check if
				// there exists more pattern
				// Example: aaaaaaaa, aa
			}
		}
		return ans;
	}

	/**
	 * Compute temporary array to maintain size of suffix which is same as
	 * prefix Time/space complexity is O(size of pattern)
	 */
	private static int[] largestPrefixSuffix(String pattern) {
		int[] lps = new int[pattern.length()];
		int index = 0, i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(index)) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}