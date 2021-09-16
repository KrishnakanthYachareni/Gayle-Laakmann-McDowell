package codesignal.interview.practice;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://app.codesignal.com/interview-practice/task/uX5iLwhc6L5ckSyNC/description
 */
public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {

    }

    char firstNotRepeatingCharacter(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // if first occurrence index and last occurrence index are same then
            if (s.indexOf(c[i]) == s.lastIndexOf(c[i]))
                return c[i];
        }
        return '_';
    }
}
