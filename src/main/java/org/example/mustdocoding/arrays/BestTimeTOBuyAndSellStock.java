package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class BestTimeTOBuyAndSellStock {

    public static void bestTimeTOBuyAndSellStock1(){
        int []prices = {7,1,5,3,6,4};
        int n = prices.length;
        int min = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }

        System.out.println("Max Profit:: " + maxProfit);
    }

    // Multiple Day buy and Multiple Day Sell
    public static int bestTimeTOBuyAndSellStock2() {
        int[] prices = {7,1,5,3,6,4};
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        System.out.println("Max Profit :: " + maxprofit);
        return maxprofit;
    }

    public static void main(String[] args) {
        bestTimeTOBuyAndSellStock1();
        bestTimeTOBuyAndSellStock2();
    }
}
