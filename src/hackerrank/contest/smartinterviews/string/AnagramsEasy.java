package hackerrank.contest.smartinterviews.string;

/**
 * Given 2 strings, check if they are anagrams. An anagram is a rearrangement of
 * the letters of one word to form another word. In other words, some
 * permutation of string A must be same as string B
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       check-anagrams
 */
public final class AnagramsEasy {
	public static void main(String[] args) {
		String a = "stop";
		String b = "post";
		boolean ans = isAnagram(a, b);
		System.out.println(ans);
	}

	public static boolean isAnagram(String a, String b) {
		int n = a.length(), m = b.length();
		if (n != m) {
			return false;
		}
		int[] cntA = new int[26];
		int[] cntB = new int[26];
		for (int i = 0; i < n; i++) {
			cntA[a.charAt(i) - 'a']++;
			cntB[b.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (cntA[i] != cntB[i]) {
				return false;
			}
		}
		return true;
	}
}