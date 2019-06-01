/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSum {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1, 2);
        List<Integer> row2 = Arrays.asList(3, 4);
        matrix.add(row1);
        matrix.add(row2);
        System.out.println(findMatrix(matrix));
    }

    public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < after.size(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < after.get(0).size(); j++) {
                row.add(algo(after, i, j));
            }
            res.add(row);
        }
        return res;
    }

    private static int algo(List<List<Integer>> before, int x, int y) {
        int s = 0;
        for (int i = 0; i <= x; i += 1) {
            for (int j = 0; j <= y; j += 1) {
                s = s + before.get(i).get(j);
            }
        }
        return s;
    }
}

