/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package com.book.strings;

import java.util.Arrays;

/**
 * @author Krishnakanth Yachareni
 * @since 10-11-2018
 * <p>
 * Given two strings, write a method to decide if one is a permutation of other.
 * </p>
 * Time complexity : O(n+m) where n = one string length, m = other string length.
 * Space complexity : O(n+m)
 */
public class CheckPermutation {
    public static void main(String[] args) {
        boolean resultA = checkPermuteMethodA("abcd", "dcba"); // true
        boolean resultB = checkPermuteMethodB("wabd", "dcbaw"); // false
        System.out.println(resultA);
        System.out.println(resultB);
    }

    /**
     * Implementation based on ASCII 128 characters.
     * Time Complexity is not good for this solution.
     */
    public static boolean checkPermuteMethodA(String source, String destination) {
        if (source.length() != destination.length()) {
            return false;
        }
        int[] letters = new int[128];
        char[] strArray = source.toCharArray();
        for (char ch : strArray) {
            letters[ch]++;
        }
        for (int i = 0; i < destination.length(); i++) {
            int c = destination.charAt(i);
            letters[c]--;
            if (letters[c] > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation based on sorting of a string.
     */
    public static boolean checkPermuteMethodB(String source, String destination) {
        if (source.length() != destination.length()) {
            return false;
        }
        return Arrays.equals(sort(source), sort(destination));
    }

    private static char[] sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return content;
    }
}
