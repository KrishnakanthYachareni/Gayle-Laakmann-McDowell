/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterviews.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-reverse-the-sentence/problem
 * <p>
 * Solution: Insert words in to stack & pop one by one
 */
public final class SentenceReverse {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            Stack<String> stack = new Stack<>();
            String[] words = reader.readLine().split(" ");
            for (String word : words) {
                stack.push(word);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}
