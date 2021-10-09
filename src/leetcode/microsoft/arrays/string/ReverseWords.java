package leetcode.microsoft.arrays.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseWords {
    public static void main(String[] args) {
        String ans = reverseWords("the sky is blue");
        System.out.println(ans);
    }

    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        String temp = "";
        while (i < n) {
            if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
            } else {
                if (!temp.equals("")) {
                    st.push(temp);
                    temp = "";
                }
            }
            i++;
            if (i == n && !temp.equals(""))
                st.push(temp);
        }
        StringBuilder ans = new StringBuilder();
        while (!st.empty()) {
            String v = st.pop();
            if (st.size() != 0)
                ans.append(v).append(" ");
            else {
                ans.append(v);
            }
        }
        return ans.toString();
    }
}
