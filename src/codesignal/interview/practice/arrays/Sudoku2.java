package codesignal.interview.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codesignal.com/interview-practice/task/SKZ45AF99NpbnvgTn/description
 * <p>
 * Asked in Uber and Apple.
 */
public class Sudoku2 {
    public static void main(String[] args) {

    }

    // SPace optimized
    boolean sudoku2(char[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = grid[i][j];
                if ('.' != number) {
                    // If each row, column or 3*3 sub grid has the duplicates then simple returns the false.
                    if (!set.add(number + " row " + i) ||
                            !set.add(number + " col " + j) ||
                            !set.add(number + " box " + i / 3 + " " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Simple
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        Set<String> col = new HashSet<>();
        Set<String> box = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if ('.' != val) {
                    if (!row.add(val + " row " + i) ||
                            !col.add(val + " col " + j) ||
                            !box.add(val + " box " + i / 3 + " " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
