package codechef.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * @link https://www.codechef.com/problems/CHCOINSG
 */
public final class Chcoinsg {
	public static void main(String[] args) throws IOException {
		try {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				System.out.println(primeGame(sc.nextLong()));
			}
		} catch (Exception e) {
			return;
		}
	}

	public static String primeGame(long n) {
		if (n % 6 == 0) {
			return "Misha";
		}
		return "Chef";
	}
}