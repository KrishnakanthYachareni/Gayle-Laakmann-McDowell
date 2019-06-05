/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixSum {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> row1 = Arrays.asList(33, 94, 56, 34, 77);
        List<Integer> row2 = Arrays.asList(89, 27, 55, 74, 3);
        List<Integer> row3 = Arrays.asList(38, 20, 90, 45, 60);
        List<Integer> row4 = Arrays.asList(98, 65, 58, 18, 14);
        List<Integer> row5 = Arrays.asList(2, 64, 11, 1, 79);
        List<Integer> row6 = Arrays.asList(4, 67, 78, 13, 53);
        List<Integer> row7 = Arrays.asList(98, 68, 90, 2, 62);
        List<Integer> row8 = Arrays.asList(13, 1, 34, 75, 95);
        List<Integer> row9 = Arrays.asList(23, 16, 39, 95, 42);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        matrix.add(row5);
        matrix.add(row6);
        matrix.add(row7);
        matrix.add(row8);
        matrix.add(row9);

        for (List li : findMatrix(matrix)) {
            System.out.println(li);
        }
    }

    public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
        Integer[][] afterArr = after.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
        Integer[][] before = new Integer[after.size()][after.get(0).size()];
        for (int i = 0; i < after.size(); i++) {
            for (int j = 0; j < after.get(0).size(); j++) {
                if (i == 0 && j == 0) {
                    before[i][j] = afterArr[i][j];
                } else if (i == 0) {
                    before[i][j] = afterArr[i][j] - afterArr[i][j - 1];
                } else if (j == 0) {
                    before[i][j] = afterArr[i][j] - afterArr[i - 1][j];
                } else {
                    before[i][j] = afterArr[i][j] - afterArr[i - 1][j] - afterArr[i][j - 1] + afterArr[i - 1][j - 1];
                }
            }
        }
        return Arrays.stream(before)
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }
}

