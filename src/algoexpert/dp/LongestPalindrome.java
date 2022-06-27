package algoexpert.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /*
       Approach:
       1. Iterate through string and treat each character as a center of polindrom and             then expand left and right from center to check if it is a polindrome or not.
       2. There can be Odd palindromes and even palindromes, So need to check both.

       TC = O(N^2), SC = O(1)
   */
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        String temp;
        for (int i = 0; i < n; i++) {
            int p1 = i - 1, p2 = i + 1;

            //Odd Palindrome
            while (p1 != -1 && p2 != n && s.charAt(p1) == s.charAt(p2)) {
                p1--;
                p2++;
            }
            temp = s.substring(p1 + 1, p2);
            ans = ans.length() < temp.length() ? temp : ans;

            //Even Palindrome
            p1 = i - 1;
            p2 = i;
            while (p1 != -1 && p2 != n && s.charAt(p1) == s.charAt(p2)) {
                p1--;
                p2++;
            }
            temp = s.substring(p1 + 1, p2);
            ans = ans.length() < temp.length() ? temp : ans;
        }
        return ans;
    }
}
