package algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversel {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int row = 0, col = 0, height = array.size() - 1, width = array.get(0).size() - 1;
        List<Integer> result = new ArrayList<>();
        boolean isGoingDown = true;

        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));

            if (isGoingDown) {
                if (row == height || col == 0) {
                    isGoingDown = false;
                    if (row == height)
                        col++;
                    else
                        row++;
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    if (col == width)
                        row++;
                    else
                        col++;
                } else {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }

    private static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }
}
