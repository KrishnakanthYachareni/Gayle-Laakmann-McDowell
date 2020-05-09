package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return
 * it, In other words, arrange the elements into a sequence such that a1 >= a2
 * <= a3 >= a4 <= a5.....
 * 
 * @link https://www.interviewbit.com/problems/wave-array/
 * 
 * @Solution: Sort the array and then swap adjacent elements.
 * 
 *            Time complexity: O(nlogn)
 *
 */
public class WaveArray {

	public static void main(String[] args) {
		ArrayList<Integer> in = new ArrayList<>();
		in.add(1);
		in.add(2);
		in.add(3);
		in.add(4);
		ArrayList<Integer> ans = wave(in);
		System.out.println(ans);
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		Collections.sort(A);
		for (int i = 0; i < A.size() - 1; i += 2) {
			if (!A.get(i).equals(A.get(i + 1))) {
				int temp = A.get(i);
				A.set(i, A.get(i + 1));
				A.set(i + 1, temp);
			}
		}
		return A;
	}
}
