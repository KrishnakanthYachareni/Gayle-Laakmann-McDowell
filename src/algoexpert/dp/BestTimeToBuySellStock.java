package algoexpert.dp;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuySellStock {

    /*
        Approach: Maintain two variables - minPrice and maxProfit corresponding to the
        smallest valley and maximum profit (maximum difference between selling price and minprice)
        obtained so far respectively.
        TC = O(N), SC = O(1)
    */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
