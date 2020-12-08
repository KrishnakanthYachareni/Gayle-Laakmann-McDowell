/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.techmojo.part2;

import java.util.PriorityQueue;

public class KMostFrequentWords {

    public static void main(String[] args) throws Exception {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Trie root = new Trie();
        int k = 10;
        String text = "Elon Musk co-founded and leads #Tesla, #SpaceX, #Neuralink and The Boring #US Companies. As the co-founder and CEO of #Tesla, Elon leads all product design, engineering and global manufacturing of the company's electric vehicles, battery products and solar energy products and #Tesla also produces three energy storage products, the #Powerwall home battery, the #Powerpack commercial-scale battery, and Megapack, which is designed for utility-scale installations.Trump becomes the 45th #US President Potentially habitable exoplanet #ProximaB discovered #RogerFederer wins #US Open for 5th time #GravitationalWaves detection successful Traces of liquid water discovered on #Mars Life Could Survive on Exoplanet #ProximaB Go go #RogerFederer Ten ways #ProximaB is different from Earth ISRO becomes 4th space agency to reach #Mars #RogerFederer beats #Nadal";
        insertAndUpdateHeap(root, text, minHeap, k);
        System.out.println(minHeap);
    }

    // insert key into trie, if prefix mark end of key as leaf, update heap
    private static void insertAndUpdateHeap(Trie root, String key, PriorityQueue<Node> minHeap, int k) {
        Trie temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = Character.toLowerCase(key.charAt(i)) - 'a';
            if (temp.ar[index] == null) {
                temp.ar[index] = new Trie();
            }
            temp = temp.ar[index];
        }
        temp.isEOW = true;
        temp.count = temp.count + 1;

        // Case 1: word is already present in minHeap
        if (temp.node != null) {
            // Unless removed heap will not sort
            minHeap.remove(temp.node);
            temp.node.count = temp.count;
            minHeap.add(temp.node);
            // Case 2: word is not present and heap is not full
        } else if (minHeap.size() < k) {
            temp.node = new Node(key, temp.count);
            temp.node.trieNode = temp;
            minHeap.add(temp.node);
            // Case 3: word is not present and heap is full, and frequency is more than top of minHeap, replace it
        } else if (null != minHeap.peek() && temp.count > minHeap.peek().count) {
            Node minHeapRoot = minHeap.poll();
            minHeapRoot.trieNode = temp;
            minHeapRoot.count = temp.count;
            minHeapRoot.word = key;
            temp.node = minHeapRoot;
            minHeap.add(minHeapRoot);
        }
    }

    static class Trie {
        Trie[] ar;
        int count;
        boolean isEOW;
        Node node = null;

        Trie() {
            this.ar = new Trie[26];
            this.count = 0;
            this.isEOW = false;
        }
    }

    static class Node implements Comparable<Node> {
        String word;
        int count;
        Trie trieNode;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Node n) {
            return count - n.count;
        }

        public String toString() {
            return word + ": " + count;
        }
    }
}
