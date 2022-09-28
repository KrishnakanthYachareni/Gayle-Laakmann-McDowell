package algoexpert.strings;

/*
 * Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a palindrome.
 * A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.
 *
 * LC: https://leetcode.com/problems/valid-palindrome/
 */
public class PalindromeCheck {

    // TC = O (N), O(1)
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
