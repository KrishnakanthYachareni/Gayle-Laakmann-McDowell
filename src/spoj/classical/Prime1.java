/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package spoj.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @link https://www.spoj.com/problems/PRIME1/
 *       <p>
 *       Solution:
 *       <p>
 *       <p>
 *       1. https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 *       <p>
 *       2.
 *       https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/
 */
public final class Prime1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			printPrimes(a, b);
		}
	}

	/**
	 * Reference:
	 * https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/
	 */
	static void printPrimes(int a, int b) {
		if (a == 1) { // if "a" starts from 1 it would be added into primes list
						// so making "a+1"
			a++;
		}
		List<Integer> primes = compute1e5Primes((int) 1e5); // Find all primes
															// upto 1e5
		boolean[] ar = new boolean[b - a + 1]; // given range of numbers falgs
		Arrays.fill(ar, true);
		for (int p : primes) {
			if (p * p <= b) { // in b-a+1 range primes are possible till the
								// sqrt(b)
				int x = (a / p) * p; // initial value of prime in b-a+1 range
				// Just like sieve algorithm mark as false for every prime+prime
				// as non-prime in bool array.
				for (int i = x; i <= b; i += p) {
					if (i != p && i >= a) { // "i" shouldn't be the less than
											// low(a) & not prime mark as false.
						ar[i - a] = false;
					}
				}
			}
		}
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]) {
				System.out.println(a + i);
			}
		}
	}

	/**
	 * Generate the primes numbers from 1 - 1e5 by using sieve of eratosthenes.
	 *
	 * @reference https://www.geeksforgeeks.org/sieve-of-eratosthenes/
	 */
	private static List<Integer> compute1e5Primes(int n) {
		List<Integer> primes = new ArrayList<>();
		boolean[] p = new boolean[n + 1];
		Arrays.fill(p, true);
		for (int i = 2; i * i <= n; i++) {
			if (p[i]) {
				for (int j = 2 * i; j <= n; j += i) {
					p[j] = false;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (p[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}