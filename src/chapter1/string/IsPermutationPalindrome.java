/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package chapter1.string;

/**
 * @author Krishnakanth Yachareni
 * @since 11-11-2018
 * <p>
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary.
 * </p>
 * Time complexity : O(N) where N = string length.
 * Space complexity : O(N)
 * <p>
 * Solution:
 * 1) We need to have an even number of almost all characters,
 * so that half can be on one side and half can be on other side.
 * At most one character(the middle character) can have an odd count.
 * <p>
 * Example:
 * Input : "Tact Coa"
 * Output: true (permutations: "taco cat", atco cta", etc.)
 */
public class IsPermutationPalindrome {
    public static void main(String[] args) {
        boolean res = isPermutationPalindrome("aba");
        System.out.println(res);
    }

    public static boolean isPermutationPalindrome(String str) {
        int[] table = buildCharFrequencyTable(str.toCharArray());
        boolean foundOdd = false;
        for (int num : table) {
            // First odd accept for the second odd returns false.
            if (num % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * build the table by counting the each character occurrences and then returns it.
     */
    private static int[] buildCharFrequencyTable(char[] chars) {
        //Character.getNumericValue() returns unicode value of character in integer. Here both small, capital are having same value.
        //Size of the table is 26.(35 - 10 + 1)
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char ch : chars) {
            int val = getCharNumber(ch);
            if (val != -1) {
                table[val]++;
            }
        }
        return table;
    }

    /**
     * Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     * This is case insensitive. Non -letter characters map to -1.
     */
    private static int getCharNumber(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if (a <= val && val <= z) {
            //Which returns characters in integer range from 0-25. (b - a) = (11 - 10) = 1.
            return val - a;
        }
        // Non - letters
        return -1;
    }
}
