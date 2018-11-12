/*
 * Copyright (c) 2018 Krishnakanth Yachareni. All rights reserved.
 */

package chapter1.string;

/**
 * @author Krishnakanth Yachareni
 * @since 12-11-2018
 * <p>
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the
 * string "aabcccccaaa" would become "a2b1c5a3". If "compressed" string would not become smaller than original string, your
 * method should return the original string.(You can assume that string has only upper & lower case letters)
 * <p>
 * If we use StringBuilder/StringBuffer for an implementation
 * Time complexity : O(n) where n = Length of input string.
 * <p>
 * If we use normal String concat with '+'
 * Time Complexity : O(n + c) where n length of the string & c count of repeated characters in a string.
 */
public class StringCompression {
    public static void main(String[] args) {
        String result = compressString("aabcccccaaa");
        System.out.println(result);
    }

    private static String compressString(String str) {
        StringBuilder builder = new StringBuilder();
        int countFrequency = 0;
        for (int i = 0; i < str.length(); i++) {
            countFrequency++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                builder.append(str.charAt(i));
                builder.append(countFrequency);
                countFrequency = 0;
                if (builder.toString().length() > str.length()) {
                    return str;
                }
            }
        }
        return builder.toString().length() <= str.length() ? builder.toString() : str;
    }
}
