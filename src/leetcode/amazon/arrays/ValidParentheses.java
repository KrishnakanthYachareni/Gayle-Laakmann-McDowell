package leetcode.amazon.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * <p>
 * Link: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean ans = isValid("{[]}");
        System.out.println(ans);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        List<Character> open = Arrays.asList('(', '{', '[');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (open.contains(ch)) {
                stack.push(ch);
            } else {
                char peek = stack.peek();
                if (peek == '(' && ch == ')' || peek == '{' && ch == '}' || peek == '[' && ch == ']') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size() == 1;
    }
}
