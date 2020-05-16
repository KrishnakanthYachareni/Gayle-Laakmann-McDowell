package interviewbit.twopointer;

import java.util.ArrayList;

/**
 * Given an array and a value, remove all the instances of that value in the
 * array. Also return the number of elements left in the array after the
 * operation. It does not matter what is left beyond the expected length
 *
 * @link https://www.interviewbit.com/problems/remove-element-from-array/
 *       <p>
 *       Complexity: O(n), O(1)
 */
public final class RemoveElement {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(4);
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(3);

		int length = removeElement(a, 1);
		System.out.println(length);
	}

	public static int removeElement(ArrayList<Integer> a, int b) {
		int i = 0;
		int j = 0;
		ArrayList<Integer> temp = (ArrayList<Integer>) a.clone();
		while (i < temp.size()) {
			if (temp.get(i) != b) {
				if (i != j) {
					temp.set(j, temp.get(i));
					temp.set(i, b);
				}
				j++;
			}
			i++;
		}
		a.clear();
		for (int k = 0; k < j; k++) {
			a.add(temp.get(k));
		}
		return j;
	}
}