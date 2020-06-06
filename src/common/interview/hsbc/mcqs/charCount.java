/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.hsbc.mcqs;

import java.util.HashMap;
import java.util.Set;

// a : 2
//J : 2
public class charCount {
    static void charNum(String inputString) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        char[] strArray = inputString.toCharArray();
        for (char c : strArray) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        Set<Character> charsInString = charMap.keySet();
        for (Character ch : charsInString) {
            if (charMap.get(ch) > 1) {
                System.out.println(ch + " : " + charMap.get(ch));
            }
        }
    }

    public static void main(String[] args) {
        charNum("JavaJ2Ee");
    }
}
