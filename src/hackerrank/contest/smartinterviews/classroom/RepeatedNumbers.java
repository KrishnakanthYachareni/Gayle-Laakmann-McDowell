package hackerrank.contest.smartinterviews.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given an array of n+2 elements. All elements of the array are in
 * range 1 to n. All elements occur once except two numbers, which occur twice.
 * Your task is to find the two repeating numbers
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       repeated-numbers/problem
 *       <p>
 *       Solution: Simply sort the array and iterate the array linearly & check
 *       for duplicates.
 */
public final class RepeatedNumbers {
	public static void main(String[] args) {
		int[] ar = { 1, 3, 2, 3, 4, 6, 5, 5 };
		findDuplicates(ar, ar.length);
	}

	private static void findDuplicates(int[] ar, int n) {
		Set<Integer> hashSet = new HashSet<>();
		List<Integer> ans = new ArrayList<>();
		for (int item : ar) {
			if (!hashSet.add(item)) {
				ans.add(item);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.get(0) + " " + ans.get(1));
	}
}