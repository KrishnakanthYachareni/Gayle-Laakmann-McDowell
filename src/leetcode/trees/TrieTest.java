package leetcode.trees;


import java.util.HashMap;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Trie");
    }
}

class TrieNode {
    boolean eow;
    TrieNode[] ar;

    public TrieNode() {
        this.ar = new TrieNode[26];
        this.eow = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (node.ar[idx] == null) {
                node.ar[idx] = new TrieNode();
            }
            node = node.ar[idx];
        }
        node.eow = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (node.ar[idx] == null) {
                return false;
            }
            node = node.ar[idx];
        }
        return node.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < prefix.length(); i++) {
            idx = prefix.charAt(i) - 'a';
            if (node.ar[idx] == null) {
                return false;
            }
            node = node.ar[idx];
        }
        return true;
    }
}
