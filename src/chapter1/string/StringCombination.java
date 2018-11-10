/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package chapter1.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Krishnakanth Yachareni
 * @since 10-11-2018
 * <p>
 * Find the all combinations of a String even if string has duplicate characters.
 * </p>
 * Time complexity : O(2^n) where n = string length.
 * Space complexity : O(n) where n = string length(include duplicate characters)
 * <p>
 * Solution:
 * 1) When going into recursion, find leftmost non zero count since index/pos.
 * <p>
 * 2) when coming out of recursive call, first move pointer 1 step ahead and then find first non zero count. since index/pos.
 * <p>
 * Example:
 * Input : "AABC"
 * Output: [A, AA, AAB, AABC, AAC, AB, ABC, AC, B, BC, C]
 * @implNote https://www.youtube.com/watch?v=xTNFs5KRV_g&t=835s
 */
public class StringCombination {
    public static void main(String[] args) {
        List<String> res = combination("AABC");
        System.out.println(res);
    }

    public static List<String> combination(String input) {
        Map<Character, Integer> countMap = countNumberOfChars(input);
        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        char[] result = new char[input.length()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        combinationUtil(str, count, result, 0, 0, resultList);
        return resultList;
    }

    /**
     * It counts each character & it's repetitions in a string.
     *
     * @param input string
     * @return Sorted map which has characters & their count of repetitions.
     */
    private static Map<Character, Integer> countNumberOfChars(String input) {
        // TreeMap for sorting each character in an order.
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input.toCharArray()) {
            countMap.compute(ch, (key, val) -> {
                if (val == null)
                    return 1;
                else {
                    return val + 1;
                }
            });
        }
        return countMap;
    }

    private static void combinationUtil(char[] str, int[] count, char[] result, int pos, int level, List<String> resultList) {
        // First time result[0] is null to avoid to insert that into string lit this condition has made.
        // '\u0000' is the default value for a character. Its decimal equivalent is 0.
        if (result[0] != '\u0000') {
            resultList.add(new String(result, 0, level));
        }
        for (int i = pos; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            // Assign start letter to result.
            result[level] = str[i];
            // go to next level & decrease the count same.
            count[i]--;
            combinationUtil(str, count, result, i, level + 1, resultList);
            // keep count is same while backtracking.
            count[i]++;
        }
    }
}
