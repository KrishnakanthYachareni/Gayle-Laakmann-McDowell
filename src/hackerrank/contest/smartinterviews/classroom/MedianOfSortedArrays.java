package hackerrank.contest.smartinterviews.classroom;

/**
 * Class room problem.
 */
public final class MedianOfSortedArrays {

	public static void main(String[] args) {
		int[] a = { 3, 10, 12, 18, 23 };
		int[] b = { -8, -2, 1, 7, 13, 15, 27, 31 };
		int ans = median(a, a.length, b, b.length);
		System.out.println(ans);
	}

	public static int median(int[] a, int n, int[] b, int m) {
		int low = Math.min(a[0], b[0]), high = Math.max(a[n - 1], b[m - 1]), mid;
		while (low <= high) {
			mid = (low + high) / 2;
			int smallCount = f1(a, n, mid) + f1(b, m, mid);
			int greaterCount = f2(a, n, mid) + f2(b, m, mid);
			if (smallCount > greaterCount) {
				high = mid - 1;
			} else if (smallCount < greaterCount) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return 0;
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
