package codesignal.interview.practice.basic;

/**
 * https://app.codesignal.com/interview-practice/task/dQD4TCunke2JQ98rj/description
 */
public class ArrayMaxConsecutiveSum {
    public static void main(String[] args) {
        int[] in = {-3, -2, -1, -4};
        int ans = arrayMaxConsecutiveSum2(in);
        System.out.println(ans);
    }

    static int arrayMaxConsecutiveSum2(int[] inputArray) {
        //Kaden's Algorithm
        int maxSum = inputArray[0], currSum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            currSum = Math.max(inputArray[i] + currSum, inputArray[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

