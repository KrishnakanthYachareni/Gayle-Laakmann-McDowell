package algoexpert.recursion;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    /*
   Approach: DFS
       TC = O (NM * 3^S) where S = The Longest word length, W = number of words
       initially we could have at most 4 directions to explore, but further the choices are reduced into 3
       SC = O(NM)
   */
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                boolean isWordExists = dfs(board, row, col, word, 0);
                if (isWordExists)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (board[row][col] == '#') {
            return false;
        }

        board[row][col] = '#'; // Mark visited nodes

        int[] rowOffSets = {-1, 0, 1, 0};
        int[] colOffSets = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffSets[i];
            int newCol = col + colOffSets[i];

            boolean isExists = dfs(board, newRow, newCol, word, index + 1);

            if (isExists) {
                return true;
            }
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
