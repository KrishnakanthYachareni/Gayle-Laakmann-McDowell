/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package chapter1.string;

/**
 * @author Krishnakanth Yachareni
 * @since 11-11-2018
 * <p>
 * There are three types of edits that can be performed on strings: insert a Character, remove a Character,
 * replace a Character. Given two strings, write a function to check if they are one edit(or zero edits) away.
 * </p>
 * Time complexity : O(N) where N = shorter string length.
 * Space complexity : O(N)
 * <p>
 * Solution:
 * Compare each character and ensure that the strings are only different by one.
 * <p>
 * Examples:
 * "pale", "ple" ->   true
 * "pales", "pale" -> true
 * "pale", "bale" ->  true
 * "pale", "bae"  ->  false
 */
public class OneAway {
    public static void main(String[] args) {
        boolean res = oneEditAway("pale", "pales");
        System.out.println(res);
    }

    private static boolean oneEditAway(String first, String second) {
        // Get shorter and Longer strings
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;
        //Length checks
        if ((longer.length() - shorter.length()) > 1) {
            return false;
        }
        int index1 = 0, index2 = 0;
        boolean foundDifference = false;
        while (index2 < longer.length() && index1 < shorter.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                // Ensure that this is the first difference found.
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                // On replace, move shorter pointer.
                if (shorter.length() == longer.length()) {
                    index1++;
                }
            } else {
                // If matching move shorter pointer.
                index1++;
            }
            // Always move pointer for longer string.
            index2++;
        }
        return true;
    }
}
