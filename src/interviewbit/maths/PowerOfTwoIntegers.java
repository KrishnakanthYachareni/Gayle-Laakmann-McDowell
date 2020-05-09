package interviewbit.maths;

/**
 * <p>
 * Given a positive integer which fits in a 32 bit signed integer, find if it
 * can be expressed as A^P where P > 1 and A > 0. A and P both should be
 * integers.
 *
 * @link https://www.interviewbit.com/problems/power-of-two-integers/
 *       <p>
 *       Example Input : 125 Output : true as 5^3 = 125 Explanation:
 *       <p>
 *       </>If we take log on both sides, we get: log a = log (x^y) log a = y
 *       log x y = log a / log x
 *       </p>
 * @link https://www.ideserve.co.in/learn/check-if-a-number-can-be-expressed-as-
 *       x-raised-to-power-y-set-2
 */
public final class PowerOfTwoIntegers {
	public static void main(String[] args) {
		int ans = isPower(5);
		System.out.println(ans);
	}

	private static int isPower(int A) {
		if (A == 1) {
			return 1;
		}
		for (int i = 2; i <= Math.sqrt(A); i++) {
			double value = Math.log(A) / Math.log(i);
			if (value - (int) value < 0.000000001) {
				return 1;
			}
		}
		return 0;
	}
}