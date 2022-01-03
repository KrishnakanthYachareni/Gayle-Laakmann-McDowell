package dynamicporgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int ans = coinChange(coins, 11);
        System.out.println(ans);
    }

    /**
     * Tabulation (Bottom up)
     * <p>
     * Time complexity : O(S∗n)
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // filling with invaluable value of amount.
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Recursive solution
     */
    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        else {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if ((amount - coin) >= 0) {
                    minCoins = Math.min(minCoins, 1 + coinChangeRecursive(coins, amount - coin));
                }
            }
            return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }
    }

}
