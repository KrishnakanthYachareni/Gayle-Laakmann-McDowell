package algoexpert.arrays;

import java.util.Arrays;

/**
 * Given an array of positive integers representing the values of coins in your
 * possession, write a function that returns the minimum amount of change (the
 * minimum sum of money) that you cannot create.
 * <p>
 * The given coins can have
 * any positive integer value and aren't necessarily unique (i.e., you can have
 * multiple coins of the same value).
 */
public class NonConstructableChange {

    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);
        int amountChange = 0;
        for (int coin : coins) {
            if (amountChange + 1 < coin)
                return amountChange + 1;
            amountChange += coin;
        }
        return amountChange + 1;
    }
}
