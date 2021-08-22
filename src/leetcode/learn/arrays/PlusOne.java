package leetcode.learn.arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * @link: https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9};
        int[] ans = new PlusOne().plusOne(digits);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public int[] plusOne(int[] digits) {
        int[] ans;
        int n = digits.length;
        int lastSum = digits[n - 1] + 1;
        if (lastSum < 9) {
            ans = new int[n];
            for (int i = 0; i < n - 1; i++) {
                ans[i] = digits[i];
            }
            ans[n - 1] = lastSum;
        } else {
            int carry = 0, i;
            for (i = n - 1; i >= 0; i--) {
                lastSum = i == n - 1 ? lastSum : carry + digits[i];
                carry = lastSum / 10;
                digits[i] = lastSum % 10;
            }
            if (carry >= 1) {
                ans = new int[n + 1];
                ans[0] = carry;
            } else {
                return digits;
            }
        }
        return ans;
    }
}
