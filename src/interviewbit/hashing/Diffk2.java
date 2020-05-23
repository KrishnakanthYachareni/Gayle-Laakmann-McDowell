package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array A of integers and another non negative integer k, find if
 * there exists 2 indices i and j such that A[i] - A[j] = k, i != j
 *
 * @link https://www.interviewbit.com/problems/diffk-ii/
 */
public final class Diffk2 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(5);
		a.add(3);
		int ans = diffPossible(a, 2);
		System.out.println(ans);
	}

	public static int diffPossible(final List<Integer> A, int B) {
		if (A.size() <= 1) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int item : A) {
			if (set.contains(item + B) || set.contains(item - B)) {
				return 1;
			}
			set.add(item);
		}
		return 0;
	}
}