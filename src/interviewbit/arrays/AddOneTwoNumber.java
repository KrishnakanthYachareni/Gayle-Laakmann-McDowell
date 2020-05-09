package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the
 * number ( increment the number represented by the digits ). The digits are
 * stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * If the vector has [1, 2, 3]
 * <p>
 * the returned vector should be [1, 2, 4]
 * <p>
 * as 123 + 1 = 124
 *
 * @link https://www.interviewbit.com/problems/add-one-to-number/
 */
public final class AddOneTwoNumber {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		al.add(9);
		al.add(0);
		al.add(3);
		al.add(5);
		System.out.println(addOneToNumber(al));
	}

	public static ArrayList<Integer> addOneToNumber(final ArrayList<Integer> A) {
		int i = 0;
		// remove zeroes at the front
		while (i < A.size() - 1 && A.get(i) == 0) {
			A.remove(i);
		}

		int carry = 1;
		int sum;
		for (i = A.size() - 1; i >= 0; i--) {
			sum = A.get(i) + carry;
			A.set(i, sum % 10);
			carry = sum / 10;
			// no need of further processing if carry is zero
			if (carry == 0) {
				break;
			}
		}
		// if carry is still left
		if (carry != 0) {
			A.add(0, carry);
		}
		return A;
	}
}