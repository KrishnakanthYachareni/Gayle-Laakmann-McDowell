package interviewbit.arrays;

import java.util.ArrayList;

/**
 * @link https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public final class InfiniteGrid {
	public static void main(String[] args) {
		ArrayList<Integer> X = new ArrayList<>();
		X.add(0);
		X.add(1);
		X.add(1);
		ArrayList<Integer> Y = new ArrayList<>();
		Y.add(0);
		Y.add(1);
		Y.add(2);
		int ans = coverPoints(X, Y);
		System.out.println(ans);
	}

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int sum = 0;
		for (int i = 0; i < A.size() - 1; i++) {
			sum += maxMove(A, B, i);
		}
		return sum;
	}

	private static int maxMove(ArrayList<Integer> A, ArrayList<Integer> B, int index) {
		return Math.max(Math.abs(A.get(index + 1) - A.get(index)), Math.abs(B.get(index + 1) - B.get(index)));
	}
}