package hackerrank.contest.smartinterviews.maths;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ross and Rachael are afraid of prime numbers, but they are not afraid of all
 * prime numbers. They were afraid of only a special kind of prime numbers. They
 * are afraid of the prime numbers (without the digit zero, they love all the
 * primes which have digits 0 in them) that remain prime no matter how many of
 * the leading digits are omitted. For example, they are afraid of 4632647
 * because it doesn't have the digit 0 and each of its truncations (632647,
 * 32647, 2647, 647, 47, and 7) are primes.
 * <p>
 * You are given a simple task, given a number of N, find out the number of
 * primes not greater that N, that Ross and Rachael are afraid of.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       prime-fear
 *       <p>
 *       Think I/O impacts time to
 *       Follow:https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-
 *       programming/
 *       <p>
 *       Complexity: O(n*log(log(n))), O(n)
 */
public final class PrimeFear {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] ans = primesSieve((int) 1e6);
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			writer.write(String.valueOf(ans[n]));
			writer.newLine();
			writer.flush();
		}
	}

	/**
	 * Pre compute primes [1-1e6] using sieve algorithm and find the pre compute
	 * count array of primes
	 */
	private static int[] primesSieve(int n) {
		int[] ans = new int[n + 1];
		boolean[] p = new boolean[n + 1];
		p[0] = true;
		p[1] = true;
		for (int i = 2; i * i <= n; i++) {
			if (!p[i]) {
				for (int j = i * i; j <= n; j += i) {
					p[j] = true;
				}
			}
		}
		ans[2] = 1;
		for (int i = 2; i <= n; i++) {
			if (!p[i] && isNotAfraidPrime(p, i)) {
				ans[i] = ans[i - 1] + 1;
			} else {
				ans[i] = ans[i - 1];
			}
		}
		return ans;
	}

	private static boolean isNotAfraidPrime(boolean[] p, int prime) {
		if (isNumberContainsZero(prime)) {
			return false;
		}
		for (int i = 6; i > 0; i--) {
			int mod = (int) Math.pow(10, i);
			if (p[prime % mod]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check whether the given n contains zero as digit or not.
	 */
	private static boolean isNumberContainsZero(int n) {
		while (n > 0) {
			if (n % 10 == 0) {
				return true;
			}
			n /= 10;
		}
		return false;
	}
}