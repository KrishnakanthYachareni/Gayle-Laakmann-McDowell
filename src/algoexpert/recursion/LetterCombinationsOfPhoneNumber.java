package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {

    /*
        Time complexity: O(4^N * N) where N is the length of digits.
        Note that 4 in this expression is referring to the maximum value length in the keypad,

        Space = O(N)
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        String[] mapping = new String[]{
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsBacktrack(digits, 0, "", mapping, result);

        return result;
    }

    private void letterCombinationsBacktrack(String digits, int index, String current, String[] mapping, List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            letterCombinationsBacktrack(digits, index + 1, current + letter, mapping, result);
        }
    }
}
