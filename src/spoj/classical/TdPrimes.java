package spoj.classical;

/**
 * @link https://www.spoj.com/problems/TDPRIMES/
 *       <p>
 *       Complexity: O(log(log(n))), O(n)
 */
public final class TdPrimes {
	public static void main(String[] args) {
		int n = (int) 1e8;
		primes(n);
	}

	/**
	 * Find prime numbers using sieve algorithm.
	 */
	public static void primes(int n) {
		boolean[] p = new boolean[n + 1];
		p[0] = true;
		p[1] = true;
		for (int i = 4; i <= n; i += 2) {
			p[i] = true;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (!p[i]) {
				for (int j = i * i; j <= n; j += (i * 2)) {
					p[j] = true;
				}
			}
		}
		int c = 1;
		System.out.println(2);
		for (int i = 3; i <= n; i += 2) {
			if (!p[i]) {
				c++;
				if (c % 100 == 1) {
					System.out.println(i);
				}
			}
		}
	}
}