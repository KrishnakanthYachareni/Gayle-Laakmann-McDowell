package interviewbit.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * @link https://www.interviewbit.com/problems/palindrome-string/
 */
public final class ValidPalindrome {
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		int ans = isPalindrome(str);
		System.out.println(ans);
	}

	private static int isPalindrome(String A) {
		String ls = A.toLowerCase();
		int p1 = 0;
		int p2 = ls.length() - 1;
		while (p1 <= p2) {
			if (!Character.isLetterOrDigit(ls.charAt(p1))) {
				p1++;
				continue;
			}
			if (!Character.isLetterOrDigit(ls.charAt(p2))) {
				p2--;
				continue;
			}
			if (ls.charAt(p1) != ls.charAt(p2)) {
				return 0;
			}
			p1++;
			p2--;
		}
		return 1;
	}
}
