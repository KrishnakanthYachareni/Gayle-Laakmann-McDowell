package leetcode.cisco;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        String num = "10";
        String ans = removeKdigits(num, 2);
        System.out.println(ans);
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!stack.empty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // If all the numbers are in the ascending order and this special case arises.
        // Where 'K' numbers should be deleted from the last elements
        while (k-- > 0) {
            stack.pop();
        }

        // Now remove the leading zeros if any
        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ans.append(digit);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
