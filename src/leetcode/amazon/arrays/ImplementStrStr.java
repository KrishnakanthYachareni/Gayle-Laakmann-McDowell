package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        int ans = strStr("abc", "c");
        System.out.println(ans);
    }

    /**
     * Using KMP (Knuth–Morris–Pratt algorithm)
     * <p>
     * Reference:https://www.youtube.com/watch?v=GTJr8OvyEVQ
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int[] lps = largestPrefixSuffix(needle); // Largest Prefix & Suffix.
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as
     * prefix and the Time/space complexity is O(size of pattern)
     */
    private static int[] largestPrefixSuffix(String pattern) {
        int[] lps = new int[pattern.length()];
        int index = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else { // No matching is pre/suffix is found and moving to the next character
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Brute Force: TC = O(M * N). It exceeds the time limit
     */
    /*public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < (haystack.length() - needle.length()) + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }*/
}
