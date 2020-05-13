package hackerrank.contest.smartinterviews;

/**
 * You have a collection of N rods. Each rod has a unique mark on it. You are
 * given the lengths of each rod. You have to tell how many different triangles
 * can be formed using these rods
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       count-the-triangles
 */
public final class CountTriangle {
	public static void main(String[] args) {
		int[] ar = { 20, 67, 72, 83, 23, 59 };
		mergeSort(ar, 0, ar.length - 1);
		int ans = countTriangle(ar, ar.length);
		System.out.println(ans);
	}

	/**
	 * Some of the any two sides of a triangle should be more than third side,
	 * then the given three sides can form a triangle. (Triangle Inequality
	 * theorem)
	 */
	private static int countTriangle(int[] rods, int n) {
		int ans = 0;
		for (int i = n - 1; i >= 1; i--) {
			int p1 = 0, p2 = i - 1;
			while (p1 < p2) {
				if (rods[p1] + rods[p2] > rods[i]) {
					// If it is possible with rods[l], rods[r] and rods[i] then
					// it is also possible with rods[p1+1]..rods[p2-1], rods[r]
					// and rods[i]
					ans += p2 - p1;
					p2--;
				} else {
					p1++;
				}
			}
		}
		return ans;
	}

	private static void mergeSort(int[] ar, int low, int high) {
		if (low == high) {
			return;
		} else {
			int mid = (low + high) / 2;
			mergeSort(ar, low, mid);
			mergeSort(ar, mid + 1, high);
			merge(ar, low, mid, high);
		}
	}

	private static void merge(int[] ar, int low, int mid, int high) {
		int p1 = low, p2 = mid + 1, index = 0;
		int[] temp = new int[high - low + 1];
		while (p1 <= mid && p2 <= high) {
			if (ar[p1] < ar[p2]) {
				temp[index++] = ar[p1++];
			} else {
				temp[index++] = ar[p2++];
			}
		}
		while (p1 <= mid) {
			temp[index++] = ar[p1++];
		}
		while (p2 <= high) {
			temp[index++] = ar[p2++];
		}
		for (int i = low; i <= high; i++) {
			ar[i] = temp[i - low];
		}
	}
}
