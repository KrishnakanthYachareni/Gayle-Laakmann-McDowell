package codeforces.ratingless1300;

import java.util.Scanner;

/**
 * @link http://codeforces.com/contest/263/problem/A
 */
public final class BeautifulMatrix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[][] matrix = new char[5][5];
		for (int i = 0; i < 5; i++) {
			matrix[i] = in.nextLine().replaceAll(" ", "").toCharArray();
		}
		int r = -1, c = -1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[i][j] == '1') {
					r = i;
					c = j;
					break;
				}
			}
		}
		int moves = Math.abs(r - 2) + Math.abs(c - 2);
		System.out.println(moves);
		in.close();
	}
}