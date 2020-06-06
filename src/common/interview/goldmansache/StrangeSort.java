/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.goldmansache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrangeSort {
    public static void main(String[] args) {
        List<Integer> mappings = Arrays.asList(2, 1, 4, 8, 6, 3, 0, 9, 7, 5);
        List<String> nums = Arrays.asList("12", "02", "4", "023", "65", "83", "224", "50");
        System.out.println(strangeSort(mappings, nums));
    }

    public static List<String> strangeSort(List<Integer> mapping, List<String> nums) {
        List<String> interMediate = rotate(nums, mapping, true);
        sort(interMediate);
        return rotate(interMediate, mapping, false);
    }

    private static List<String> rotate(List<String> list, List<Integer> mapping, boolean isIndex) {
        List<String> res = new ArrayList<>();
        for (String num : list) {
            StringBuilder whole = new StringBuilder();
            for (char ch : num.toCharArray()) {
                int value;
                if (isIndex) {
                    value = mapping.indexOf(Integer.parseInt(String.valueOf(ch)));
                } else {
                    value = mapping.get(Integer.parseInt(String.valueOf(ch)));
                }
                whole.append(String.valueOf(value));
            }
            res.add(String.valueOf(whole.toString()));
        }
        return res;
    }

    private static void sort(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(j))) {
                    String tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}
