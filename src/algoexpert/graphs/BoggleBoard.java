package algoexpert.graphs;

import java.util.*;

public class BoggleBoard {

    // TC = O(nm * 8^s + ws) where n = rows, m = columns, s = the longest word length, w = number words
    // SC = O (nm)
    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        Set<String> finalWords = new HashSet<>(); // To avoid duplicate words
//        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                explore(i, j, board, trie.root, finalWords);
            }
        }

        return new ArrayList<>(finalWords);
    }

    // Without visited Array SC = O (nm)
    private static void explore(int i, int j, char[][] board, TrieNode trieNode, Set<String> finalWords) {

        if (board[i][j] == '#') // If already visited
            return;

        char letter = board[i][j];
        if (!trieNode.children.containsKey(letter)) // If there's is no word with letter statrts with
            return;

        board[i][j] = '#';  // Marking visited
        trieNode = trieNode.children.get(letter);

        if (trieNode.children.containsKey('*')) // End of the word.
            finalWords.add(trieNode.word);

        List<int[]> neighbors = getNeighbors(i, j, board);
        for (int[] neighbor : neighbors) {
            explore(neighbor[0], neighbor[1], board, trieNode, finalWords); // DFS
        }
        board[i][j] = letter; // Mark the non-valid words back to not visited path bcz these letters can be part of other words flow.
    }

    // With visited Array SC = O (nm + ws)
    /*private static void explore(int i, int j, char[][] board, TrieNode trieNode,
                                boolean[][] visited, Set<String> finalWords) {

        if (visited[i][j])
            return;

        char letter = board[i][j];
        if (!trieNode.children.containsKey(letter))
            return;

        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);

        if (trieNode.children.containsKey('*')) // End of the word.
            finalWords.add(trieNode.word);

        List<int[]> neighbors = getNeighbors(i, j, board);
        for (int[] neighbor : neighbors) {
            explore(neighbor[0], neighbor[1], board, trieNode, visited, finalWords); // DFS
        }
        visited[i][j] = false;
        // Mark the non-valid words back to not visited path bcz these letters can be part of other words flow.
    }*/

    private static List<int[]> getNeighbors(int row, int col, char[][] board) {
        List<int[]> neighbors = new ArrayList<>();
        int[] rowOffset = {-1, -1, 1, 1, -1, 0, 1, 0};
        int[] colOffset = {-1, 1, 1, -1, 0, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length) {
                continue;
            }
            neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    static class Trie {
        TrieNode root;
        char endSymbol;

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
