package hackerrank.contest.smartinterviews.string;

/**
 * Given a string of characters, find the first repeating character.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-find
 *       -first-repeating-character
 */
public final class FirstRepeatingChar {
	public static void main(String[] args) {
		String str = "algorithms";
		char ans = firstRepeating(str);
		System.out.println(ans);
	}

	public static char firstRepeating(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return str.charAt(i);
				}
			}
		}
		return '.';
	}
}
