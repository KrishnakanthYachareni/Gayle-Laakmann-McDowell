package leetcode.facebook.arrays;


import java.util.Arrays;
import java.util.Stack;

// TODO:
public class ValidParenthesesString {
    public static void main(String[] args) {
        String in = "lee(t(c)o)de)";
        String ans = solve(in);
        System.out.println(ans);
    }

    public static String solve(String s) {
        char[] ar = s.toCharArray();
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == '(') {
                st.push(new Pair(ar[i], i));
            } else if (ar[i] == ')') {
                st.pop();
            } else {

            }
        }
        return s;
    }

    static class Pair {
        public char parenthesis;
        public int index;

        public Pair(char c, int i) {
            this.index = i;
            this.parenthesis = c;
        }
    }
}
