/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.hsbc.mcqs;

import java.util.ArrayList;
import java.util.List;

// Compilation Error
public class StrPerm {
    public static void main(String args[]) {

        List<String> output = StrPerm.genPerm("AB");
        output.stream().forEach(System.out::println);
    }

    public static List<String> genPerm(String input) {
        List<String> strList = new ArrayList<>();
        StrPerm.permutations("", input, strList);
        return strList;
    }

    private static void permutations(String consChars, String str, List<String> opContainer) {

        for (int i = 0; i < str.length(); i++) {
//            permutations(consChars + str.charAt(i), str.substring(0, +str.substring(i + 1), opContainer);
        }
    }
}
