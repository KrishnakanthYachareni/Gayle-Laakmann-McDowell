package algoexpert.graphs;

public class WordSearch {

    // TC = O (nm * 4^s), SC = O(nm) where s = length of the word
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isWordExists = explore(board, i, j, word, 0);
                if (isWordExists)
                    return true;
            }
        }
        return false;
    }

    private static boolean explore(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row == board.length || col < 0 || col == board[0].length
                || board[row][col] != word.charAt(index))
            return false;

        board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int i = 0; i < 4; ++i) {
            boolean isWordExists = explore(board, row + rowOffsets[i], col + colOffsets[i], word, index + 1);
            if (isWordExists)
                return true;
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
