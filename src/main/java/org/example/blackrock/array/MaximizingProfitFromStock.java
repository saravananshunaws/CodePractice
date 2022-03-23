package org.example.blackrock.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class MaximizingProfitFromStock {

    // Buy and Sell Stock 1
    //  You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    // Buy and Sell Stock 2
    //On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
    public static int maxProfitVariation(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

     // Hacker Rank Problem
    public static long maxProfitReverse(int[] prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i >= 0 ; i--) {
           if (prices[i] >= maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        int []prices = {1, 2, 100};
        System.out.println("maxProfitForward:: " + maxProfit(prices));
        System.out.println("maxProfitVariation:: " + maxProfitVariation(prices));
        System.out.println("maxProfitReverse:: " + maxProfitReverse(prices));
    }

}
