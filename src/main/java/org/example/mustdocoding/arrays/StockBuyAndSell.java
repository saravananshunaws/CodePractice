package org.example.mustdocoding.arrays;

public class StockBuyAndSell {

    public static void buyAndSellV1(){
        int []prices = {7,1,5,3,6,4};
        int n = 6;
        int profit = 0, min = prices[0];
        for(int i=1; i < n; i++){
            if(min > prices[i]){
                min = prices[i];
            }

            profit = Math.max(profit , prices[i] - min);
        }

        System.out.println("Profit :: " + profit);
    }

    public static void buyAndSellV2(){
        int N = 6;
        int A[] = {7,1,5,3,6,4};
        int left = 0;
        int right = 0;
        int profit = 0;

        while (right < N - 1) {
            while (right < N - 1 && A[right] < A[right + 1])
                right++;

            System.out.println("Index :: left :: " + left + ", Right:: " + right);
            profit += A[right] - A[left];
            left = right + 1;
            right++;
        }

        System.out.println("Profit :: " + profit);
    }

    public int maxProfit(int prices[]) {
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

    public static void main(String[] args) {
        //buyAndSellV1();
        buyAndSellV2();
    }
}
