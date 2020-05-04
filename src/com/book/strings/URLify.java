/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package com.book.strings;

import java.util.Arrays;

/**
 * @author Krishnakanth Yachareni
 * @since 10-11-2018
 * <p>
 * Write a method to replace all spaces in a string with '%20'.You may assume that the string has sufficient
 * spaces at the end to hold the additional characters, and that you are given the "true" length od the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * </p>
 * Time complexity : O(n) where n = string true length.
 * Space complexity : O(n)
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {
    public static void main(String[] args) {
        char input[] = "Mr Krishna Kanth    ".toCharArray();
        replaceSpaces(input, 16);
        Arrays.asList(input).forEach(i -> System.out.print(i));
    }

    private static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, i, index;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        // if one space is there extra buffer would be 2 spaces for "%20".
        index = trueLength + spaceCount * 2;
        //Ending array in case of excess spaces.
        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
