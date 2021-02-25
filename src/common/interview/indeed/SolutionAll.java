package common.interview.indeed;

import java.util.*;

public class SolutionAll {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
        String str = "Ravi had been saying that he had been there";
        System.out.println(firstRepeatedWord(str));
    }

    public static String firstRepeatedWord(String sentence) {
        String[] words = sentence.split("\\W+");
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (String s : words) {
            if (map.containsKey(s) && map.get(s).equalsIgnoreCase(s)) {
                return s;
            } else {
                map.put(s, s);
            }
        }
        return null;
    }

    public static List<Integer> fibonacci(int n) {
        List<Integer> res = new ArrayList<>();
        int c1 = 0, c2 = 1;
        res.add(c1);
        for (int i = 1; i < n; i++) {
            res.add(c2);
            int next = c1 + c2;
            c1 = c2;
            c2 = next;
        }
        return res;
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Set<Integer> set = new HashSet<>();
        int c = 0;
        for (int i : stocksProfit) {
            if (set.contains(Math.toIntExact(target) - i))
                c++;
            else
                set.add(i);
        }
        return c;
    }
}
