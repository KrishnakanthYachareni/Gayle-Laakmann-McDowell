package spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.spoj.com/problems/TDKPRIME/
 *       <p>
 *       Complexity: O(n*log(log(n))), O(n)
 */
public final class TdKPrime {
	public static void main(String[] args) throws IOException {
		int[] primes = primes((int) 1e8);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while (t-- > 0) {
			int k = Integer.parseInt(reader.readLine());
			System.out.println(primes[k]);
		}
	}

	/**
	 * Find prime numbers using sieve algorithm.
	 */
	public static int[] primes(int n) {
		int noOfPrimes = 5000001;
		boolean[] p = new boolean[n + 1];
		int[] primes = new int[noOfPrimes + 1];
		p[0] = true;
		p[1] = true;
		for (int i = 4; i <= n; i += 2) { // Eliminate even numbers
			p[i] = true;
		}
		for (int i = 3; i * i <= n; i += 2) { // Traverse through odd numbers
			if (!p[i]) {
				for (int j = i * i; j <= n; j += (i * 2)) { // eliminate
															// multiples of
															// primes
					p[j] = true;
				}
			}
		}
		int index = 1;
		primes[index++] = 2;
		for (int i = 3; i <= n; i += 2) {
			if (!p[i]) {
				if (index > noOfPrimes) {
					break;
				}
				primes[index++] = i;
			}
		}
		return primes;
	}
}