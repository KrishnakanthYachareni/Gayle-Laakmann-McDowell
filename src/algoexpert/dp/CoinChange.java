package algoexpert.dp;

import java.util.Arrays;

/*
    https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    /*
       Top Down/Tabulation
       TC = O(s*n), SC = O(s), s = amount
   */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /*  *//*
       Brute Force Solution
       TC = O(S^n), SC = O(n), S = amount
   *//*
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0)
                minCoins = Math.min(minCoins, 1 + coinChange(coins, amount - coin));
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
*/

}
