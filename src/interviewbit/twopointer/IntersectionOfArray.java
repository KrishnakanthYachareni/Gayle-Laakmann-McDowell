package interviewbit.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the intersection of two sorted arrays. OR in other words, Given 2 sorted
 * arrays, find all the elements which occur in both the arrays.
 *
 * @link https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 *       <p>
 *       Solution: Use Two pointer technique
 *       <p>
 *       Complexity: O(n+m)
 */
public final class IntersectionOfArray {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		ArrayList<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(3);
		b.add(5);
		ArrayList<Integer> ans = intersection(a, b);
		System.out.println(ans);
	}

	public static ArrayList<Integer> intersection(final List<Integer> A, final List<Integer> B) {
		int p1 = 0, p2 = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while (p1 < A.size() && p2 < B.size()) {
			int x = A.get(p1);
			int y = B.get(p2);
			if (x == y) {
				ans.add(x);
				p1++;
				p2++;
			} else if (x < y) {
				p1++;
			} else {
				p2++;
			}
		}
		return ans;
	}
}
