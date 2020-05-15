package hackerrank.contest.smartinterviews;

/***
 * Given an array,you have to find the frequency of a number
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-frequency
 *
 *       Sol: Using one binary search.
 */
public final class FindingFrequencyUsingOneBS {
	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		mergeSort(ar, 0, ar.length - 1);
		int[] queries = { -1, 10, 8, 15, 20 };
		for (int x : queries) {
			int occurrenceIdx = binarySearch(ar, ar.length, x);
			if (occurrenceIdx != -1) {
				int ans = countOccurrences(ar, occurrenceIdx, x);
				System.out.println(ans);
			} else {
				System.out.println("0");
			}
		}
	}

	private static int countOccurrences(int[] ar, int occurrenceIdx, int x) {
		int left = occurrenceIdx - 1, right = occurrenceIdx + 1, ans = 1;
		while (left >= 0 && ar[left] == x) {
			ans++;
			left--;
		}
		while (right < ar.length && ar[right] == x) {
			ans++;
			right++;
		}
		return ans;
	}

	private static int binarySearch(int[] ar, int length, int x) {
		int low = 0, high = length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x == ar[mid]) {
				return mid;
			} else if (x > ar[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
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