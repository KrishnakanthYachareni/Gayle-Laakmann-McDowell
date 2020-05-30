package interview.vitech.set2;

/**
 * Question: https://1o24bbs.com/t/topic/10142
 * <p>
 * Ans: https://stackoverflow.com/questions/58055310/how-can-i-break-down-this-
 * gambling-problem
 */
public final class Gamble {
	public static void main(String[] args) {
		int ans = solution(8, 0);
		System.out.println(ans);
	}

	public static int solution(int N, int K) {
		int ans = 0;
		while (N != 1) {
			if (K > 0 && (N & 1) != 1) {
				N = N / 2;
				ans++;
				K--;
			} else {
				N--;
				ans++;
			}
		}
		return ans;
	}
}
