package interviewbit.binarysearch;

import java.util.ArrayList;

/**
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * <p>
 * Find an return the overall median of the matrix A.
 * <p>
 * Note: No extra memory is allowed.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left
 * to righ
 *
 * @link https://www.interviewbit.com/problems/matrix-median/
 */
public final class MatrixMedian {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(3);
		row1.add(5);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(2);
		row2.add(6);
		row2.add(9);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(3);
		row3.add(6);
		row3.add(9);
		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
		int median = findMedian(mat);
		System.out.println(median);
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> A) {
		if (A.isEmpty()) {
			return -1;
		}
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE, mid;
		int n = A.size(), m = A.get(0).size();
		for (ArrayList<Integer> integers : A) {
			low = Math.min(low, integers.get(0));
			high = Math.max(high, integers.get(m - 1));
		}
		int median = 1;
		while (low <= high) {
			mid = (low + high) / 2;
			// Id mid is less than total elements/2. then look for
			if (isLessThanHalfMatrix(A, mid, n, m)) {
				low = mid + 1;
			} else {
				median = mid;
				high = mid - 1;
			}
		}
		return median;
	}

	/**
	 * This method returns the boolean by checking the total elements which are
	 * less than k is less than half of the whole matrix elements(i.e, half of
	 * the total elements in the matrix).
	 */
	private static boolean isLessThanHalfMatrix(ArrayList<ArrayList<Integer>> a, int k, int n, int m) {
		int lesserCount = 0;
		for (ArrayList<Integer> integers : a) {
			lesserCount += binarySearch(integers, k);
		}
		int totalElements = (n * m) / 2 + 1;
		return lesserCount < totalElements;
	}

	/**
	 * Find the index of element k.
	 */
	private static int binarySearch(ArrayList<Integer> a, int k) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a.get(mid) > k) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}