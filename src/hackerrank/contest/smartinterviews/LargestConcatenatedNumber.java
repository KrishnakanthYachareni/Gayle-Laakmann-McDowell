package hackerrank.contest.smartinterviews;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the largest number that can be constructed
 * by concatenating all the elements of the given array.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       largest-concatenated-number
 *       <p>
 *       Solution: For example, let X and Y be 542 and 60. To compare X and Y,
 *       we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y
 *       first.
 */
public final class LargestConcatenatedNumber {
	public static void main(String[] args) {
		List<String> ar = Arrays.asList("69", "9", "57", "60");
		customSort(ar);
		ar.forEach(System.out::print);
	}

	/**
	 * a.compareTo(b) < 0 // a < b
	 * <p>
	 * a.compareTo(b) > 0 // a > b
	 * <p>
	 * a.compareTo(b) == 0 // a == b
	 */
	private static void customSort(List<String> numbers) {
		numbers.sort((x, y) -> {
			String xy = x + y;
			String yx = y + x;
			return xy.compareTo(yx) > 0 ? -1 : 1;
		});
	}
}
