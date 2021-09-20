package codesignal.interview.practice.basic;

/**
 * https://app.codesignal.com/interview-practice/task/4MoqQLaw22nrzXbgs/description
 */
public class SumInRange {
    public static void main(String[] args) {
        int[] nums = {3, 0, -2, 6, -3, 2};
        int[][] queries = {{0, 2}, {2, 5}, {0, 5}};
        int ans = sumInRange(nums, queries);
        System.out.println(ans);
    }

    static int sumInRange(int[] nums, int[][] queries) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int sum = 0;
        for (int[] query : queries) {
            sum += (prefixSum[query[1] + 1] - prefixSum[query[0]]);
        }

        // Modulo function
        return Math.floorMod(sum, 1000000007);
    }

}
