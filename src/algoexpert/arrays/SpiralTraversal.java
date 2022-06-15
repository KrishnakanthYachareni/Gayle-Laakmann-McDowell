package algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given m * n matrix print in the spiral order.
 * <p>
 * Solution: Watch the algo experts video
 */
public class SpiralTraversal {

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> ans = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1, startCol = 0, endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {

            for (int c = startCol; c <= endCol; c++)
                ans.add(array[startRow][c]);

            for (int r = startRow + 1; r <= endRow; r++)
                ans.add(array[r][endCol]);

            for (int c = endCol - 1; c >= startCol; c--) {
                // When single row in the middle of the matrix, we don't want to double count the values in this row.
                if (startRow == endRow) break;
                ans.add(array[endRow][c]);
            }

            for (int r = endRow - 1; r > startRow; r--) {
                // When there's single column in the middle of the matrix, we don't want to double-count the values in this column.
                if (startCol == endCol) break;
                ans.add(array[r][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return ans;
    }
}
