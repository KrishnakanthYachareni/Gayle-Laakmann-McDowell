package interviewbit.twopointer;

import java.util.ArrayList;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array
 *
 * @link https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 *       <p>
 *       Solution: Use Two pointer technique
 *       <p>
 *       Complexity: O(n+m)
 */
public final class MergeSortedArrays {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		a.add(1);
		a.add(5);
		a.add(8);
		b.add(6);
		b.add(8);
		merge(a, b);
		System.out.println(a);
	}

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int p1 = 0, p2 = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while (p1 < a.size() && p2 < b.size()) {
			if (b.get(p2) < a.get(p1)) {
				ans.add(b.get(p2++));
			} else {
				ans.add(a.get(p1++));
			}
		}
		while (p1 < a.size()) {
			ans.add(a.get(p1++));
		}
		while (p2 < b.size()) {
			ans.add(b.get(p2++));
		}
		a.clear();
		a.addAll(ans);
	}
}
