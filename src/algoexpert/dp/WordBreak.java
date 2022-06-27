package algoexpert.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    /*
        Approach: Dynamic Programming
        Video: https://www.youtube.com/watch?v=iWenZCZEBIA
        Tc = O(n ^ 3), Sc = O(n)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDicSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String leftWord = s.substring(j, i);
                if (dp[j] && wordDicSet.contains(leftWord)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /*
        Brute Force: https://www.youtube.com/watch?v=LPs6Qo5qlJM
        Tc = O(2^n), Sc = O(n)

   public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> wordDicSet = new HashSet<>(wordDict);
       if (wordDicSet.contains(s))
           return true;

       for (int i = 0; i < s.length(); i++) {
           String leftWord = s.substring(0, i);
           if (wordDicSet.contains(leftWord) && wordBreak(s.substring(i), wordDict)) {
               return true;
           }
       }
       return false;
    }*/
}
