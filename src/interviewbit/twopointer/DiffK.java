package interviewbit.twopointer;

import java.util.ArrayList;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * @link https://www.interviewbit.com/problems/diffk/
 *       <p>
 *       Solution: Use Two pointer technique
 *       <p>
 *       Complexity: O(n)
 */
public final class DiffK {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(4);
		int ans = diffPossible(a, 0);
		System.out.println(ans);
	}

	public static int diffPossible(ArrayList<Integer> A, int B) {
		int p1 = 0, p2 = 0;
		while (p1 < A.size() && p2 < A.size()) {
			int x = A.get(p1);
			int y = A.get(p2);
			if (y - x == B && p1 != p2) {
				return 1;
			} else if (y - x < B) {
				p2++;
			} else {
				p1++;
			}
		}
		return 0;
	}
}