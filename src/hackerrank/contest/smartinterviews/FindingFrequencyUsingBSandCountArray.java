package hackerrank.contest.smartinterviews;

/***
 * Given an array,you have to find the frequency of a number
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       finding-frequency
 *
 *       Sol: Firstly sort the array and maintain occurrences array using two
 *       pointer technique & and then search for occurence index of every x in Q
 */
public final class FindingFrequencyUsingBSandCountArray {
	public static void main(String[] args) {
		int[] ar = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		mergeSort(ar, 0, ar.length - 1);
		int[] queries = { -1, 10, 8, 15, 20 };

		int[] occurrence = new int[ar.length];
		int size = countOccurrences(ar, occurrence, ar.length);

		for (int x : queries) {
			int index = binarySearch(ar, size + 1, x);
			if (index != -1) {
				System.out.println(occurrence[index]);
			} else {
				System.out.println("0");
			}
		}
	}

	private static int countOccurrences(int[] ar, int[] occurrence, int n) {
		int p1 = 0, p2 = 1, count = 1, index = 0;
		while (p2 < n) {
			if (ar[p1] == ar[p2]) {
				count++;
			} else {
				ar[index] = ar[p1];
				occurrence[index] = count;
				count = 1;
				index++;
			}
			p1++;
			p2++;
		}
		if (ar[index - 1] == ar[p1]) {
			occurrence[index] = occurrence[index] + 1;
		} else {
			ar[index] = ar[p1];
			occurrence[index] = 1;
		}
		return index;
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
