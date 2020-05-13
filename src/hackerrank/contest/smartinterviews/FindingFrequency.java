package hackerrank.contest.smartinterviews;

/***
 * Given an array,you have to find the frequency of a number**@link
 * https://www.hackerrank.com/contests/smart-interviews/challenges/si-finding-
 * frequency
 */
public final class FindingFrequency {
	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		mergeSort(ar, 0, ar.length - 1);
		int[] queries = { -1, 10, 8, 15, 20 };
		for (int x : queries) {
			int p1 = bsLeftIndex(ar, ar.length, x);
			int p2 = bsRightIndex(ar, ar.length, x);
			System.out.println((p2 - p1) + 1);
		}
	}

	private static int bsLeftIndex(int[] ar, int length, int x) {
		int p1 = 1, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar[mid]) {
				high = mid - 1;
			} else if (x > ar[mid]) {
				low = mid + 1;
			} else {
				p1 = mid;
				high = mid - 1;
			}
		}
		return p1;
	}

	private static int bsRightIndex(int[] ar, int length, int x) {
		int p2 = 0, low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x < ar[mid]) {
				high = mid - 1;
			} else if (x > ar[mid]) {
				low = mid + 1;
			} else {
				p2 = mid;
				low = mid + 1;
			}
		}
		return p2;
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
