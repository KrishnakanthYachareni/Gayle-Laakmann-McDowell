package leetcode.facebook.arrays;

import java.util.HashMap;
import java.util.Map;

//TODO: Need to implement fully
public class RomanToInteger {
    public static void main(String[] args) {
        String in = "MCDLXXVI";
        int ans = romanToInt(in);
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

    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i > 0; i -= 2) {
            int f = map.get(s.charAt(i));
            int l = map.get(s.charAt(i - 1));
            if (l < f) {
                ans += f - l;
            } else {
                ans += f + l;
            }
            if (i-1 == 0) {
                return ans;
            }
        }
        return ans + map.get(s.charAt(0));
    }
}
