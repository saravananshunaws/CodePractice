package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class BestTimeToBuyAndSellstock {
    public static void main(String[] args) {
       int [] prices = {7,1,5,3,6,4};
       int maxprofit = 0, minprice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }

        System.out.println("Profit :: "  + maxprofit);
    }
}
