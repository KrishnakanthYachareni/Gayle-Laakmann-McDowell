package hackerrank.contest.smartinterviews;

/**
 * Find the cube root of the given number. Assume that all the input test cases
 * will be a perfect cube. Note: Do not use any inbuilt functions/libraries for
 * your main logic
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-cuberoot
 *       <p>
 *       Solution: Implementation using binary search.
 */
public final class CubeRoot {
	public static void main(String[] args) {
		long num = (long) 1e18;
		long ans = Math.round(cubicRoot(Math.abs(num)));
		System.out.println(num < 0 ? -ans : ans);
	}

	static double cubicRoot(double n) {
		double start = 0, end = n;
		double e = 0.0000001;
		while (true) {
			double mid = (start + end) / 2;
			double error = diff(n, mid);
			if (error <= e) {
				return mid;
			}
			if ((mid * mid * mid) > n) {
				end = mid;
			} else {
				start = mid;
			}
		}
	}

	static double diff(double n, double mid) {
		if (n > (mid * mid * mid)) {
			return (n - (mid * mid * mid));
		} else {
			return ((mid * mid * mid) - n);
		}
	}
}