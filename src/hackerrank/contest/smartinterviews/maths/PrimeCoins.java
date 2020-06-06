package hackerrank.contest.smartinterviews.maths;

import java.util.Scanner;

/**
 * Santa and Banta are playing a game of coins. They have a pile containing N
 * coins. Players take alternate turns, removing some coins from the pile. On
 * each turn, a player can remove either one coin or coins equal to some prime
 * power (i.e. px coins, where p - prime number and x - positive integer). Game
 * ends when the pile becomes empty. The player who can not make a move in his
 * turn loses.
 * <p>
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       prime-coins
 *       <p>
 *       Complexity: O(1), O(1)
 * @link https://discuss.codechef.com/t/chcoinsg-editorial/12657
 *       <p>
 *       Learn game theory to tackle these kind of problems.
 */
public final class PrimeCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.println(primeGame(sc.nextLong()));
		}
	}

	public static String primeGame(long n) {
		if (n % 6 == 0) {
			return "Banta";
		}
		return "Santa";
	}
}
