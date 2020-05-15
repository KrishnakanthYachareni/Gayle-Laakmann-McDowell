package interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
 * Considering each array element Ai as the edge length of some line segment,
 * count the number of triangles which you can form using these array values.
 *
 * @link https://www.interviewbit.com/problems/counting-triangles/
 */
public final class CountingTriangle {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		int ans = nTriang(list);
		System.out.println(ans);
	}

	/**
	 * Some of the any two sides of a triangle should be more than third side,
	 * then the given three sides can form a triangle. (Triangle Inequality
	 * theorem)
	 */
	public static int nTriang(ArrayList<Integer> A) {
		Collections.sort(A);
		int bigPrime = (int) (1e9 + 7);
		int ans = 0;
		for (int i = A.size() - 1; i >= 1; i--) {
			int p1 = 0, p2 = i - 1;
			while (p1 < p2) {
				if (A.get(p1) + A.get(p2) > A.get(i)) {
					// If it is possible with rods[l], rods[r] and rods[i] then
					// it is also possible with rods[p1+1]..rods[p2-1], rods[r]
					// and rods[i]
					ans = (ans + (p2 - p1) % bigPrime) % bigPrime;
					p2--;
				} else {
					p1++;
				}
			}
		}
		return ans % bigPrime;
	}
}
