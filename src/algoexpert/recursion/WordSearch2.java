package algoexpert.recursion;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {

    /*
    Approach: DFS
        TC = O (NM * 3^S) where S = The Longest word length, W = number of words
        initially we could have at most 4 directions to explore, but further the choices are reduced into 3
        SC = O(NM)
    */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>(); // To avoid the duplicates

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                explore(board, row, col, trie.root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void explore(char[][] board, int row, int col, TrieNode root, Set<String> result) {

        if (board[row][col] == '#') { // Avoid already visited node
            return;
        }

        char letter = board[row][col];
        if (!root.children.containsKey(letter))
            return;

        board[row][col] = '#'; // Mark visted node

        root = root.children.get(letter);

        if (root.children.containsKey('*')) { // End of word
            result.add(root.word);
        }

        List<int[]> neighbors = getNeighbors(board, row, col);
        for (int[] neighbor : neighbors) {
            explore(board, neighbor[0], neighbor[1], root, result);
        }

        board[row][col] = letter;
    }


    private List<int[]> getNeighbors(char[][] board, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        int[] rowOffSets = {-1, 0, 1, 0};
        int[] colOffSets = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffSets[i];
            int newCol = col + colOffSets[i];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
                continue;

            neighbors.add(new int[]{newRow, newCol});
        }

        return neighbors;
    }

    static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public String word = null;
    }

    static class Trie {
        public TrieNode root;
        public Character endSymbol;

        public Trie() {
            this.root = new TrieNode();
            this.endSymbol = '*';
        }

        public void add(String word) {
            TrieNode node = this.root;

            for (char letter : word.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(this.endSymbol, null);
            node.word = word;
        }
    }
}
