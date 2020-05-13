package hackerrank.contest.smartinterviews;

/**
 * There are 2 teams, each having N players. There will be N rounds played
 * between the 2 teams. In every round, a player from team A plays against a
 * player from team B. The more powerful player wins the game. Given the
 * strength of the players of both the teams, you have to find the maximum
 * number of rounds team A can win. Note that a player cannot play more than 1
 * round.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       power-game/problem
 */
public final class PowerGame {
	public static void main(String[] args) {
		int[] teamA = { 1, 5, 7, 4 };
		int[] teamB = { 3, 8, 2, 10 };
		mergeSort(teamA, 0, teamA.length - 1);
		mergeSort(teamB, 0, teamB.length - 1);
		int ans = powerGame(teamA, teamB, teamA.length);
		System.out.println(ans);
	}

	private static int powerGame(int[] teamA, int[] teamB, int n) {
		int p1 = 0, p2 = 0, ans = 0;
		while (p1 < n && p2 < n) {
			if (teamA[p1] > teamB[p2]) {
				ans++;
				p1++;
				p2++;
			} else {
				p1++;
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
