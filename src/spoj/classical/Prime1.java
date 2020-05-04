/*
 * Copyright (c) 2020 Krishnakanth Yachareni. All rights reserved.
 */

package spoj.classical;

import java.util.Scanner;

/**
 * @link https://www.spoj.com/problems/PRIME1/
 */
// TODO: This implementation is not best and which is In progress.
public final class Prime1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++) {
				if (isPrime(j)) {
					System.out.println(j);
				}
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}