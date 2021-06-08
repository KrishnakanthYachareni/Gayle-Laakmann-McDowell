package hackerrank.contest.smartinterviews.string;

/**
 * Given a string, find the length of the largest palindromic substring.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       largest-palindromic-substring
 */
public final class LargestPalindrome {
	public static void main(String[] args) {
		String str = "pfyafafd";
		int n = str.length();
		int ans = largestPalindromicSubstring(str, n);
		System.out.println(ans);
	}

	public static int largestPalindromicSubstring(String str, int n) {
		int ans = 1;
		for (int i = 0; i < n; ++i) {
			// Odd Palindrome Case
			int p1 = i - 1, p2 = i + 1;
			while (p1 != -1 && p2 != n && str.charAt(p1) == str.charAt(p2)) {
				--p1;
				++p2;
			}
			ans = Math.max(ans, (p2 - p1 - 1));
			// Even Palindrome Case
			p1 = i - 1;
			p2 = i;
			while (p1 != -1 && p2 != n && str.charAt(p1) == str.charAt(p2)) {
				--p1;
				++p2;
			}
			ans = Math.max(ans, (p2 - p1 - 1));
		}
		return ans;
	}
}
