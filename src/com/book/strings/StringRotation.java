/*
 * Copyright (c) 2018 Krishnakanth Yachareni. All rights reserved.
 */

package com.book.strings;

/**
 * @author Krishnakanth Yachareni
 * @since 14-11-2018
 * <p>
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings s1 and s2,
 * write code to check if s2 is a rotation of s1 using only one call to isSsubstring (e.g, "waterbottle" is a rotation
 * of "erbottlewat")
 * <p>
 * Time Complexity: isSubString :: O(A+B), isRotation :: O(N)
 * </p>
 */
public class StringRotation {
    public static void main(String[] args) {
        boolean res = isRotation("waterbottle", "erbottlewat");
        System.out.println(res);
    }

    private static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* Check that s1 and s2 are equal and bot empty*/
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }

    private static boolean isSubString(String s1s1, String s2) {
        return s1s1.contains(s2);
    }
}
