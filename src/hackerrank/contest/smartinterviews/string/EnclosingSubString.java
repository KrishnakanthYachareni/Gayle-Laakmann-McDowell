package hackerrank.contest.smartinterviews.string;

/**
 * Given 2 strings A and B, find the smallest substring of B having all the
 * characters of A, in any order.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       enclosing-substring
 */
public final class EnclosingSubString {
	public static void main(String[] args) {
		String a = "dclzztpjldkndgbdqqzmbp";
		String b = "dzpd";

		/*
		 * String a = "uqhmfjaqtgngcwkuzyamnerphfmw"; String b = "onmwvytbytn";
		 */
		int ans = findSmallestSubStringLen(a, b);
		System.out.println(ans);
	}

	public static int findSmallestSubStringLen(String a, String b) {
		int[] cntB = new int[26];
		int[] cntA = new int[26];
		b.chars().forEach(i -> cntB[i - 'a']++);
		int i = 0, j = 0, ans = Integer.MAX_VALUE;
		while (j < a.length()) {
			cntA[a.charAt(j) - 'a']++;
			while (isFound(cntA, cntB)) {
				ans = Math.min(ans, j - i + 1);
				cntA[a.charAt(i) - 'a']--;
				i++;
			}
			j++;
		}
		return Integer.MAX_VALUE == ans ? -1 : ans;
	}

	private static boolean isFound(int[] cntA, int[] cntB) {
		for (int k = 0; k < 26; k++) {
			if (cntA[k] < cntB[k]) {
				return false;
			}
		}
		return true;
	}
}