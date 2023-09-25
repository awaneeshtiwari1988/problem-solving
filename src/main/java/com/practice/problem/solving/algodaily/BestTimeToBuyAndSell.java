package com.practice.problem.solving.algodaily;

public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int costPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            costPrice = Math.min(costPrice, prices[i]);
            maxProfit = Math.max(prices[i] - costPrice, maxProfit);
        }

        return maxProfit;
    }
}
