package interviewbit.twopointer;

import java.util.ArrayList;

/**
 * Remove duplicates from Sorted Array Given a sorted array, remove the
 * duplicates in place such that each element appears only once and return the
 * new length.
 *
 * @link https://www.interviewbit.com/problems/remove-duplicates-from-sorted-
 *       array/
 *       <p>
 *       Complexity: O(n), O(1)
 */
public final class RemoveDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(4);
		int length = removeDuplicates(a);
		System.out.println(length);
	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		ArrayList<Integer> temp = (ArrayList<Integer>) a.clone();
		int p1 = 0, p2 = 1;
		while (p2 < temp.size()) {
			if (!temp.get(p1).equals(temp.get(p2))) {
				p1++;
				temp.set(p1, temp.get(p2));
			}
			p2++;
		}
		a.clear();
		for (int i = 0; i <= p1; i++) {
			a.add(temp.get(i));
		}
		return p1 + 1;
	}
}