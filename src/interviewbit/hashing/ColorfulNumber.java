package interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * For Given Number N find if its COLORFUL number or not
 * <p>
 * Return 0/1
 * <p>
 * COLORFUL number:
 * <p>
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324
 * 245. And this number is a COLORFUL number, since product of every digit of a
 * contiguous subsequence is different
 *
 * @link https://www.interviewbit.com/problems/colorful-number/
 */
public final class ColorfulNumber {
	public static void main(String[] args) {
		int a = 3245;
		int ans = colorful(a);
		System.out.println(ans);
	}

	public static int colorful(int A) {
		String str = String.valueOf(A);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j <= str.length(); j++) {
				String sub = str.substring(i, j);
				if (!sub.equals("")) {
					int prd = product(sub);
					if (set.contains(prd)) {
						return 0;
					}
					set.add(prd);
				}
			}
		}
		return 1;
	}

	private static int product(String num) {
		int ans = 1;
		for (int i = 0; i < num.length(); i++) {
			ans *= Integer.parseInt(String.valueOf(num.charAt(i)));
		}
		return ans;
	}
}