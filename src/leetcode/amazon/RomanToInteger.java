package leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        int ans = romanToInt("III");
        System.out.println(ans);
    }

    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * Right-to-Left Pass:
     * 1. Without looking at the next symbol, we don't know whether the left-most symbol should be added or subtracted.
     * 2. The right-most symbol is always added. It is either by itself, or the additive part of a pair.
     */
    public static int romanToInt(String s) {
        int n = s.length();
        int i = n - 2, result = map.get(s.charAt(n - 1));

        while (i >= 0) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
            i--;
        }
        return result;
    }
}
