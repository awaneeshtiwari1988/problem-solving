package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class StockBuyAndSell {

    public Map<Integer, Integer> getMaximumProfit(int[] stockPrices){
        Map<Integer, Integer> stockPriceIndexes = new HashMap<>();
        int currentProfit = 0;
        int stockBuyPrice = stockPrices[0];
        int stockSellPrice = stockPrices[1];
        int maxProfit = stockSellPrice - stockBuyPrice;

        for (int i = 1; i < stockPrices.length; i++) {
            currentProfit = stockPrices[i] - stockBuyPrice;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
                stockSellPrice = stockPrices[i];
            }

            if(stockBuyPrice > stockPrices[i]){
                stockBuyPrice = stockPrices[i];
            }
        }

        stockPriceIndexes.put(stockBuyPrice, stockSellPrice);
        return stockPriceIndexes;
    }

    public static void main(String[] args) {
        StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
        int[] stockPrices = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Map<Integer, Integer> map = stockBuyAndSell.getMaximumProfit(stockPrices);
        map.forEach((k,v) -> System.out.println(k + "," + v));
    }
}
