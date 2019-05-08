package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubStringWithKDistinct {

    // Solution one
    public static List<String> subStringWithKDistinct(String s, int k) {
        if (s.length() < k) {
            return new ArrayList<>();
        }
        return deriveSubString(s, k);
    }

    // Second Solution
    public static List<String> subStringWithKDistinctAnother(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n * k == 0) {
            return null;
        }
        int left = 0, right = 0;
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == k && right - left == k + 1) {
                result.add(s.substring(left, right));
            }
        }
        if (map.size() > k) {
            int delIdx = Collections.min(map.values());
            map.remove(s.charAt(delIdx));
        }
        return result;
    }

    private static List<String> deriveSubString(String s, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j - i == k) {
                    String out = s.substring(i, j);
                    if (!isUnique(out)) {
                        list.add(out);
                    }
                }
            }
        }
        return list;

    }

    private static boolean isUnique(String s) {
        char[] sArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sArr) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(subStringWithKDistinctAnother("awaglk", 4));
    }
}