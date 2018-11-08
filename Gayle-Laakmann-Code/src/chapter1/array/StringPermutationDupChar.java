/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package chapter1.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Krishnakanth Yachareni
 * @since 08-11-2018
 * <p>
 * Find the all permutations of a String even if string has duplicate characters.
 * </p>
 * Time complexity : O(K * k!) where K = Unique characters in a string. k= number of permutations of a string.
 * Space complexity : O(n) where n = string length(include duplicate characters)
 * <p>
 * Solution:
 * 1) When going into recursion, find leftmost non zero count.
 * <p>
 * 2) when coming out of recursive call, first move pointer 1 step ahead and then find first non zero count.﻿
 * <p>
 * Example:
 * Input : "AABC"
 * The Number of permutations = 4!/2! * 1! * 1! = 12
 * Output: [AABC, AACB, ABAC, ABCA, ACAB, ACBA, BAAC, BACA, BCAA, CAAB, CABA, CBAA]
 */
public class StringPermutationDupChar {
    public static void main(String[] args) {
        List<String> res = permutation("AABC");
        System.out.println(res);
    }

    public static List<String> permutation(String input) {
        Map<Character, Integer> countMap = countNumberOfChars(input);
        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char[] result = new char[input.length()];
        permuteUtil(str, count, result, 0, resultList);
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

    private static void permuteUtil(char[] str, int[] count, char[] result, int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            // Assign start letter to result.
            result[level] = str[i];
            // go to next level & decrease the count same.
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            // keep count is same while backtracking.
            count[i]++;
        }
    }
}
