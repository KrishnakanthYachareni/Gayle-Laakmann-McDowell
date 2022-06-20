package algoexpert.trees;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    // TODO: Look the optimal solution in the video to use bidirectional BFS (complexities are same but pefromance is best)
    /*
     BFS Approach:
           TC = O(M^2 * N) where M = Length of the beginning word, N = Total number of word in wordlist.
           SC = O(M * N)
          Video: https://leetcode.com/problems/word-ladder/solution/
           https://www.youtube.com/watch?v=5iFZP-f40iI
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> lookup = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        lookup.remove(beginWord); // Already visited

        int numberOfWords = 1;

        while (!queue.isEmpty()) { // O (N)
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) { // O (M)
                    return numberOfWords;
                }

                List<String> neighbors = getNeighbors(currentWord); // O (M ^ 2)
                for (String neighbor : neighbors) {
                    if (lookup.contains(neighbor)) { // O(1)
                        queue.add(neighbor);
                        lookup.remove(neighbor); // Visited So that we're removing from the set.
                    }
                }
            }
            numberOfWords++;
        }

        return 0; // If there is no end word exists in the word list.
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) { // O (M)
            char temp = wordChars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                wordChars[i] = ch;

                String newWord = new String(wordChars); // O (M)
                neighbors.add(newWord);
            }
            wordChars[i] = temp;
        }
        return neighbors;
    }
}
