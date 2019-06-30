/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.hcl;

import java.util.*;

public class MissingWordsFromSubSequence {
    public static void main(String[] args) {
        String t = "I am using hackerrank to improve programming";
        String s = "am hackerrank to improve";
        System.out.println(missingwords(t, s));
    }

    private static List<String> missingwords(String t, String s) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : t.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word : s.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList<>();
        for (String word : count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans;
    }
}

