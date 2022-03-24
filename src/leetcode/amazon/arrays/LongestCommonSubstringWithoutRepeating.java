package leetcode.amazon.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestCommonSubstringWithoutRepeating {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("aab");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(i, map.get(ch));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(ch, j + 1);
        }
        return ans;
    }
}
