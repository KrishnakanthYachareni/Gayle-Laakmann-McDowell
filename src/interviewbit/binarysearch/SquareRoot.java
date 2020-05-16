package interviewbit.binarysearch;

/**
 * Given an integar A.
 * <p>
 * Compute and return the square root of A.
 * <p>
 * If A is not a perfect square, return floor(sqrt(A)).
 * <p>
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 *
 * @link https://www.interviewbit.com/problems/square-root-of-integer/
 */
public final class SquareRoot {
	public static void main(String[] args) {
		int ans = sqrt(11);
		System.out.println(ans);
	}

	private static int sqrt(int A) {
		long low = 0, high = A, ans = 0, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			long square = mid * mid;
			if (square == A) {
				return (int) mid;
			}
			if (square < A) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		return (int) ans;
	}
}