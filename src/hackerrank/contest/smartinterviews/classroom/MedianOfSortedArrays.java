package hackerrank.contest.smartinterviews.classroom;

/**
 * Class room problem.
 */
public final class MedianOfSortedArrays {

	// TODO:
	public static void main(String[] args) {
		int[] ar = { 3, 10, 12, 18, 23 };
		int ans = f2(ar, ar.length, 24);
		System.out.println(ans);
	}

	static int f1(int[] ar, int n, int x) {
		int low = 0, high = n - 1, mid, ans = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (ar[mid] >= x) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid + 1;
			}
		}
		return ans;
	}

	static int f2(int[] ar, int n, int x) {
		int low = 0, high = n - 1, mid, ans = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (ar[mid] > x) {
				high = mid - 1;
				ans = n - mid;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}