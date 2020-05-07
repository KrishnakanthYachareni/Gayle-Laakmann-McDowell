/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous sub array within an array, A of length N which has the
 * largest sum
 * 
 * @link https://www.interviewbit.com/courses/programming/
 * 
 *       Solution: Use Kadane's algorithm to implement linear solution
 * 
 *       Time Complexity: O(n)
 * 
 *       Kadane's Explanation: @link https://www.youtube.com/watch?v=jnoVtCKECmQ
 */
public class MaxSumContiguousSubArray {

	public static void main(String[] args) {
		List<Integer> in = Arrays.asList(1, 2, 3, 4, -10);
		int ans = maxSubArray(in);
		System.out.println(ans);
	}

	public static int maxSubArray(final List<Integer> A) {
		int max = A.get(0);
		int currentSum = max;
		for (int i = 1; i < A.size(); i++) {
			currentSum = Math.max(currentSum + A.get(i), A.get(i));
			max = Math.max(currentSum, max);
		}
		return max;
	}

}
