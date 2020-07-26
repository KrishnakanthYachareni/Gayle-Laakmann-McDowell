/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.certification.java;

import java.util.Scanner;
import java.util.Stack;

public class ValidBrackets {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }
        in.close();
    }
}

class Parser {
    public boolean isBalanced(String s) {
        int f = 1, i, l = s.length();
        Stack<Character> st = new Stack<>();
        for (i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                if (st.empty()) {
                    f = 0;
                    break;
                } else {
                    char c = st.pop();
                    if ((c == '(' && ch != ')') || (c == '[' && ch != ']') || (c == '{' && ch != '}')) {
                        f = 0;
                        break;
                    }
                }
            }
        }
        return f == 1 && st.empty();
    }
}

