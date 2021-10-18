package leetcode.amazon;

/**
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Similar Variation: https://www.hackerrank.com/contests/smart-interviews/challenges/si-largest-palindromic-substring
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String ans = longestPalindrome("cbbd");
//        System.out.println(ans);
        System.out.println(10/10);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        String ans = "", temp;
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
