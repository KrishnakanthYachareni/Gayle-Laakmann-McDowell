package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Given an array,you have to find the frequency of a number
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-frequency
 *
 *       Sol: Using Two binary searchsO.
 */
public final class SearchForRange {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(5, 7, 7, 8, 8, 10);
		ArrayList<Integer> ans = searchRange(a, 8);
		System.out.println(ans);
	}

	public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList<>();
		int left = bsLeftIndex(A, A.size(), B);
		int right = bsRightIndex(A, A.size(), B);
		if (left != -1 && right != -1) {
			ans.add(left);
			ans.add(right);
		} else {
			ans.add(-1);
			ans.add(-1);
		}
		return ans;
	}

	private static int bsLeftIndex(List<Integer> ar, int length, int x) {
		int p1 = -1, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar.get(mid)) {
				high = mid - 1;
			} else if (x > ar.get(mid)) {
				low = mid + 1;
			} else {
				p1 = mid;
				high = mid - 1;
			}
		}
		return p1;
	}

	private static int bsRightIndex(List<Integer> ar, int length, int x) {
		int p2 = -1, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar.get(mid)) {
				high = mid - 1;
			} else if (x > ar.get(mid)) {
				low = mid + 1;
			} else {
				p2 = mid;
				low = mid + 1;
			}
		}
		return p2;
	}
}