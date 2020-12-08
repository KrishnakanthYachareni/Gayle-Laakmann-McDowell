/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.techmojo.part2;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem: Find the top 10 trending hashtags in twitter. You can write a standalone java class(es) / interfaces as deemed to be fit.
 */
public class TopTweetsWithMap {

    private static final int K = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        String text = "Elon Musk co-founded and leads #Tesla, #SpaceX, #Neuralink and The Boring #US Companies. As the co-founder and CEO of #Tesla, Elon leads all product design, engineering and global manufacturing of the company's electric vehicles, battery products and solar energy products and #Tesla also produces three energy storage products, the #Powerwall home battery, the #Powerpack commercial-scale battery, and Megapack, which is designed for utility-scale installations.Trump becomes the 45th #US President Potentially habitable exoplanet #ProximaB discovered #RogerFederer wins #US Open for 5th time #GravitationalWaves detection successful Traces of liquid water discovered on #Mars Life Could Survive on Exoplanet #ProximaB Go go #RogerFederer Ten ways #ProximaB is different from Earth ISRO becomes 4th space agency to reach #Mars #RogerFederer beats #Nadal";
        String text = reader.readLine();

        Map<String, Integer> map = extractHashTags(text);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(K);

        minify(map, minHeap);

        // Display Top 10 hashTags.
        while (minHeap.size() > 0) {
            writer.write(minHeap.remove().getHashTag());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    /**
     * Extracting the each hashTag from given tweet text and inserting into hashmap to maintains the frequencies of the hashtags.
     * <p>
     * Limit: Size of the hashmap depends on the available heap space on machine.
     */
    private static Map<String, Integer> extractHashTags(String text) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(#\\w+)");
        Matcher matcher;
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            //Maintaining frequency of hashTag
            map.merge(matcher.group(), 1, Integer::sum);
        }
        return map;
    }

    /**
     * we store only 10 elements in minheap and if for an element the size tends to increase we delete(MinHeap) the top
     * element (containing element with smallest frequency of hashtag)
     * <p>
     * To do so we're using minHeap data structure to maintain the top 10 hash tags.
     */
    private static void minify(Map<String, Integer> map, PriorityQueue<Node> minHeap) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //If heap has less than k hashtags.
            if (minHeap.size() < K) {
                minHeap.add(new Node(entry.getKey(), entry.getValue()));
            } else if (null != minHeap.peek() && entry.getValue() > minHeap.peek().getCount()) {
                // Perform minify to maintain most frequent hashtag
                minHeap.remove();
                minHeap.add(new Node(entry.getKey(), entry.getValue()));
            }
        }
    }

    static final class Node implements Comparable<Node> {
        private String hashTag;
        private int count;

        public Node(final String w, final int c) {
            hashTag = w;
            count = c;
        }

        @Override
        public int compareTo(final Node other) {
            // Descending order of frequency
            return other.count - this.count;
        }

        public String getHashTag() {
            return hashTag;
        }

        public void setHashTag(String hashTag) {
            this.hashTag = hashTag;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}