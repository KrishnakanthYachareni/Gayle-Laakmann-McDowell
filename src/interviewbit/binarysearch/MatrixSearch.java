package interviewbit.binarysearch;

import java.util.ArrayList;

/**
 * Given a matrix of integers A of size N x M and an integer B.
 * <p>
 * Write an efficient algorithm that searches for integar B in matrix A.
 * <p>
 * This matrix A has the following properties:
 * <p>
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than or equal to the last integer of the previous row. Return
 * 1 if B is present in A, else return 0.
 *
 * @link https://www.interviewbit.com/problems/matrix-search/
 */
public final class MatrixSearch {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(3);
		row1.add(5);
		row1.add(7);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(10);
		row2.add(11);
		row2.add(16);
		row2.add(20);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(23);
		row3.add(30);
		row3.add(34);
		row3.add(50);
		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
		int ans = matrixSearch(mat, 13);
		System.out.println(ans);
	}

	public static int matrixSearch(ArrayList<ArrayList<Integer>> A, int B) {
		if (A.isEmpty()) {
			return 0;
		}
		for (ArrayList<Integer> row : A) {
			if (row.get(row.size() - 1) >= B) {
				if (binarySearch(row, B)) {
					return 1;
				}
			}
		}
		return 0;
	}

	private static boolean binarySearch(ArrayList<Integer> a, int k) {
		int low = 0, high = a.size() - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a.get(mid) == k) {
				return true;
			} else if (k > a.get(mid)) {
				low = mid + 1;
			} else if (k < a.get(mid)) {
				high = mid - 1;
			}
		}
		return false;
	}
}
