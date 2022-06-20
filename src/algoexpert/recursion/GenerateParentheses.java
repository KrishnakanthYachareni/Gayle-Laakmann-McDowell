package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    /*
      Approach: Backtracking

      TC = This is the nth Catalan number => O(2n! / n!(n + 1)!) => O (4^n / n * sqrt(n))
      SC = same

      Video: https://www.algoexpert.io/questions/generate-div-tags
    */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;

        generateParenthesisBacktrack(n, n, "", result);

        return result;
    }

    private void generateParenthesisBacktrack(int opening, int closing, String prefix, List<String> result) {
        if (opening > 0) {
            String newPrefix = prefix + "(";
            generateParenthesisBacktrack(opening - 1, closing, newPrefix, result);
        }

        if (closing > opening) {
            String newPrefix = prefix + ")";
            generateParenthesisBacktrack(opening, closing - 1, newPrefix, result);
        }

        if (closing == 0) {
            result.add(prefix);
            return;
        }
    }
}
