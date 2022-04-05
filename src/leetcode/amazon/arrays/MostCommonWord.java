package leetcode.amazon.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String ans = mostCommonWord(para, banned);
        System.out.println(ans);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        Set<String> bannedWords = new HashSet<>();
        for (String bw : banned)
            bannedWords.add(bw.toLowerCase());

        int count = Integer.MIN_VALUE;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count && !bannedWords.contains(entry.getKey())) {
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        return ans;
    }
}
